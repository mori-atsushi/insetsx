package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import kotlinx.cinterop.CValue
import kotlinx.cinterop.ObjCAction
import platform.CoreGraphics.CGRect
import platform.UIKit.UIView

internal class WindowInsetsHolder(frame: CValue<CGRect>) : UIView(frame = frame) {
    val systemBars = UIKitWindowInsets(this)
    val navigationBars = systemBars.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom)
    val statusBars = systemBars.only(WindowInsetsSides.Top)

    @ObjCAction
    fun safeAreaInsetsDidChange() {
        systemBars.update()
    }
}
