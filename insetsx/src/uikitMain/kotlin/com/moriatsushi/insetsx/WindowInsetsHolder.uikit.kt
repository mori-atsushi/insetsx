package com.moriatsushi.insetsx

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.union
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.CValue
import kotlinx.cinterop.ObjCAction
import kotlinx.cinterop.useContents
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import platform.CoreGraphics.CGRect
import platform.Foundation.NSNotification
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSSelectorFromString
import platform.Foundation.NSTimeInterval
import platform.Foundation.NSValue
import platform.UIKit.CGRectValue
import platform.UIKit.UIKeyboardWillHideNotification
import platform.UIKit.UIKeyboardWillShowNotification
import platform.UIKit.UIView

internal class WindowInsetsHolder(
    frame: CValue<CGRect>,
    private val scope: CoroutineScope,
) : UIView(frame = frame) {
    val systemBars = UIKitSafeAreaInsets(this)
    val navigationBars = systemBars.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom)
    val statusBars = systemBars.only(WindowInsetsSides.Top)
    val ime = UIKeyboardInsets()
    val safeDrawing = systemBars.union(ime)

    init {
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

        scope.launch {
            ime.update(height, durationMillis, LinearOutSlowInEasing)
        }
    }

    @Suppress("unused")
    @ObjCAction
    fun keyboardWillHide(arg: NSNotification) {
        val durationMillis = arg.keyboardAnimationDurationMills

        scope.launch {
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
}
