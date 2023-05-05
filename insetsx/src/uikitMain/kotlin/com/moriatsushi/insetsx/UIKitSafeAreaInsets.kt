package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.useContents
import platform.UIKit.UIView

@Stable
internal class UIKitSafeAreaInsets(
    private val view: UIView,
) : WindowInsets {
    private var values by mutableStateOf(createValues())

    override fun getBottom(density: Density): Int {
        return with(density) {
            values.bottom.roundToPx()
        }
    }

    override fun getLeft(density: Density, layoutDirection: LayoutDirection): Int {
        return with(density) {
            values.left.roundToPx()
        }
    }

    override fun getRight(density: Density, layoutDirection: LayoutDirection): Int {
        return with(density) {
            values.right.roundToPx()
        }
    }

    override fun getTop(density: Density): Int {
        return with(density) {
            values.top.roundToPx()
        }
    }

    fun update() {
        values = createValues()
    }

    private fun createValues(): InsetsValues {
        return view.safeAreaInsets.useContents {
            InsetsValues(
                bottom = bottom.toFloat().dp,
                left = left.toFloat().dp,
                right = right.toFloat().dp,
                top = top.toFloat().dp
            )
        }
    }

    @Immutable
    private data class InsetsValues(
        val bottom: Dp,
        val left: Dp,
        val right: Dp,
        val top: Dp,
    )
}
