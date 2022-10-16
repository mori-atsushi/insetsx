package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

@Stable
internal class UIKeyboardInsets : WindowInsets {
    private var height by mutableStateOf(0)

    override fun getBottom(density: Density): Int {
        return height
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

    fun update(height: Int) {
        this.height = height
    }
}