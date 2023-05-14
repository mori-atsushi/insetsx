package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.useContents
import platform.UIKit.UIView

@Stable
internal class NavigationBarsInsets(
    private val isVisible: () -> Boolean
) : WindowInsets {
    private var value by mutableStateOf(0.dp)

    override fun getBottom(density: Density): Int {
        if (!isVisible()) return 0

        return with(density) {
            value.roundToPx()
        }
    }

    override fun getLeft(density: Density, layoutDirection: LayoutDirection): Int {
        return 0
    }

    override fun getRight(density: Density, layoutDirection: LayoutDirection): Int {
        return 0
    }

    override fun getTop(density: Density): Int {
        return 0
    }

    fun update(view: UIView) {
        value = view.window?.safeAreaInsets?.useContents {
            bottom.toFloat().dp
        } ?: 0.dp
    }
}