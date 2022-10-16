package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.roundToInt
import kotlinx.cinterop.useContents
import platform.UIKit.UIView
import platform.UIKit.safeAreaInsets

@Stable
internal class UIKitWindowInsets(
    private val view: UIView,
) : WindowInsets {
    private var values by mutableStateOf(createValues())

    override fun getBottom(density: Density): Int {
        return values.bottom
    }

    override fun getLeft(density: Density, layoutDirection: LayoutDirection): Int {
        return values.left
    }

    override fun getRight(density: Density, layoutDirection: LayoutDirection): Int {
        return values.right
    }

    override fun getTop(density: Density): Int {
        return values.top
    }

    fun update() {
        values = createValues()
    }

    private fun createValues(): InsetsValues {
        return view.safeAreaInsets.useContents {
            InsetsValues(
                bottom = bottom.roundToInt(),
                left = left.roundToInt(),
                right = right.roundToInt(),
                top = top.roundToInt()
            )
        }
    }

    private data class InsetsValues(
        val bottom: Int,
        val left: Int,
        val right: Int,
        val top: Int,
    )
}
