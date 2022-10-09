package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.roundToInt
import kotlinx.cinterop.useContents
import platform.UIKit.UIView
import platform.UIKit.safeAreaInsets

@Stable
class UIKitWindowInsets(
    private val view: UIView,
) : WindowInsets {
    override fun getBottom(density: Density): Int {
        return view.safeAreaInsets.useContents { bottom.roundToInt() }
    }

    override fun getLeft(density: Density, layoutDirection: LayoutDirection): Int {
        return view.safeAreaInsets.useContents { left.roundToInt() }
    }

    override fun getRight(density: Density, layoutDirection: LayoutDirection): Int {
        return view.safeAreaInsets.useContents { right.roundToInt() }
    }

    override fun getTop(density: Density): Int {
        return view.safeAreaInsets.useContents { bottom.roundToInt() }
    }
}
