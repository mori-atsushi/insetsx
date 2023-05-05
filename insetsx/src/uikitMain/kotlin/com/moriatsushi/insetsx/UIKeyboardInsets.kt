package com.moriatsushi.insetsx

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Stable
internal class UIKeyboardInsets : WindowInsets {
    private val animatable = Animatable(0.dp, Dp.VectorConverter)

    override fun getBottom(density: Density): Int {
        return with(density) {
            animatable.value.roundToPx()
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

    suspend fun update(
        height: Dp,
        durationMillis: Int,
        easing: Easing,
    ) {
        animatable.animateTo(
            targetValue = height,
            animationSpec = tween(
                durationMillis = durationMillis,
                easing = easing
            )
        )
    }
}
