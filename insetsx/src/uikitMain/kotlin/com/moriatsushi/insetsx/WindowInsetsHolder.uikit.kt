package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import kotlinx.cinterop.CValue
import kotlinx.cinterop.ObjCAction
import kotlinx.cinterop.useContents
import platform.CoreGraphics.CGRect
import platform.Foundation.NSNotification
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSSelectorFromString
import platform.Foundation.NSValue
import platform.UIKit.CGRectValue
import platform.UIKit.UIKeyboardWillHideNotification
import platform.UIKit.UIKeyboardWillShowNotification
import platform.UIKit.UIView
import kotlin.math.roundToInt

internal class WindowInsetsHolder(frame: CValue<CGRect>) : UIView(frame = frame) {
    val systemBars = UIKitSafeAreaInsets(this)
    val navigationBars = systemBars.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom)
    val statusBars = systemBars.only(WindowInsetsSides.Top)
    val ime = UIKeyboardInsets()

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
    fun safeAreaInsetsDidChange() {
        systemBars.update()
    }

    @Suppress("unused")
    @ObjCAction
    fun keyboardWillShow(arg: NSNotification) {
        val keyboardInfo = arg.userInfo!!["UIKeyboardFrameEndUserInfoKey"] as NSValue
        val keyboardHeight = keyboardInfo.CGRectValue().useContents { size.height }.roundToInt()
        ime.update(keyboardHeight)
    }

    @Suppress("unused")
    @ObjCAction
    fun keyboardWillHide(arg: NSNotification) {
        ime.update(0)
    }
}
