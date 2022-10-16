package com.moriatsushi.insetsx

import kotlinx.cinterop.CValue
import kotlinx.cinterop.ObjCAction
import platform.CoreGraphics.CGRect
import platform.UIKit.UIView

internal class WindowInsetsHolder(frame: CValue<CGRect>) : UIView(frame = frame) {
    val safeDrawing = UIKitWindowInsets(this)

    @ObjCAction
    fun safeAreaInsetsDidChange() {
        safeDrawing.update()
    }
}
