package com.moriatsushi.insetsx

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.union
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.interop.LocalUIViewController
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.CValue
import kotlinx.cinterop.ObjCAction
import kotlinx.cinterop.useContents
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import platform.CoreGraphics.CGRect
import platform.CoreGraphics.CGRectMake
import platform.Foundation.NSNotification
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSSelectorFromString
import platform.Foundation.NSTimeInterval
import platform.Foundation.NSValue
import platform.UIKit.CGRectValue
import platform.UIKit.UIKeyboardWillHideNotification
import platform.UIKit.UIKeyboardWillShowNotification
import platform.UIKit.UIView
import platform.UIKit.UIViewController
import kotlin.coroutines.CoroutineContext

internal class WindowInsetsHolder(
    private val coroutineContext: CoroutineContext
) : UIView(CGRectMake(.0, .0, .0, .0)) {
    val systemBars = UIKitSafeAreaInsets(this)
    val navigationBars = systemBars.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom)
    val statusBars = systemBars.only(WindowInsetsSides.Top)
    val ime = UIKeyboardInsets()
    val safeDrawing = systemBars.union(ime)

    private val coroutineJob = Job()
    private val coroutineScope = CoroutineScope(coroutineContext + Job())

    /**
     * The number of accesses to [WindowInsetsHolder].
     * When this increases to 1, the view is attached and the listeners are added.
     * When it reaches zero, the view is detached and listeners are removed.
     */
    private var accessCount = 0

    fun incrementAccessors(viewController: UIViewController) {
        accessCount++
        if (accessCount == 1) {
            viewController.view.insertSubview(this, 0)
            systemBars.update()
            NSNotificationCenter.defaultCenter.addObserver(
                observer = this,
                selector = NSSelectorFromString("keyboardWillShow:"),
                name = UIKeyboardWillShowNotification,
                `object` = null
            )
            NSNotificationCenter.defaultCenter.addObserver(
                observer = this,
                selector = NSSelectorFromString("keyboardWillHide:"),
                name = UIKeyboardWillHideNotification,
                `object` = null
            )
        }
    }

    fun decrementAccessors(): Boolean {
        accessCount--
        if (accessCount == 0) {
            this.removeFromSuperview()
            coroutineJob.cancel()
            NSNotificationCenter.defaultCenter.removeObserver(
                observer = this,
                name = UIKeyboardWillShowNotification,
                `object` = null
            )
            NSNotificationCenter.defaultCenter.removeObserver(
                observer = this,
                name = UIKeyboardWillHideNotification,
                `object` = null
            )
        }
        return accessCount == 0
    }

    @Suppress("unused")
    @ObjCAction
    override fun safeAreaInsetsDidChange() {
        systemBars.update()
    }

    @Suppress("unused")
    @ObjCAction
    fun keyboardWillShow(arg: NSNotification) {
        val height = arg.keyboardHeight
        val durationMillis = arg.keyboardAnimationDurationMills

        coroutineScope.launch {
            ime.update(height, durationMillis, LinearOutSlowInEasing)
        }
    }

    @Suppress("unused")
    @ObjCAction
    fun keyboardWillHide(arg: NSNotification) {
        val durationMillis = arg.keyboardAnimationDurationMills

        coroutineScope.launch {
            ime.update(0.dp, durationMillis, FastOutLinearInEasing)
        }
    }

    private val NSNotification.keyboardHeight: Dp
        get() {
            val keyboardInfo = userInfo!!["UIKeyboardFrameEndUserInfoKey"] as NSValue
            return keyboardInfo.CGRectValue().useContents { size.height }.toFloat().dp
        }

    private val NSNotification.keyboardAnimationDurationMills: Int
        get() {
            val duration = userInfo!!["UIKeyboardAnimationDurationUserInfoKey"] as NSTimeInterval
            return (duration * 1000).toInt()
        }

    companion object {
        @Composable
        fun current(): WindowInsetsHolder {
            val viewController = LocalUIViewController.current
            val coroutineContext = rememberCoroutineScope().coroutineContext
            val holder = getOrCreateFor(viewController, coroutineContext)

            DisposableEffect(holder) {
                holder.incrementAccessors(viewController)
                onDispose {
                    if (holder.decrementAccessors()) {
                        viewControllerMap.remove(viewController)
                    }
                }
            }

            return holder
        }

        private fun getOrCreateFor(
            viewController: UIViewController,
            coroutineContext: CoroutineContext
        ): WindowInsetsHolder {
            return viewControllerMap.getOrPut(viewController) {
                createFor(coroutineContext)
            }
        }

        private fun createFor(
            coroutineContext: CoroutineContext
        ): WindowInsetsHolder {
            return WindowInsetsHolder(coroutineContext)
        }
    }
}

private val viewControllerMap = mutableMapOf<UIViewController, WindowInsetsHolder>()
