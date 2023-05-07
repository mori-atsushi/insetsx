package com.moriatsushi.insetsx

import androidx.compose.runtime.Composable

internal interface WindowInsetsController {
    fun setStatusBarContentColor(dark: Boolean)
    fun setNavigationBarsContentColor(dark: Boolean)
}

@Composable
internal expect fun rememberWindowInsetsController(): WindowInsetsController?
