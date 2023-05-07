package com.moriatsushi.insetsx

import androidx.compose.runtime.Composable

internal interface WindowInsetsController {
    fun setStatusBarContentColor(dark: Boolean)
}

@Composable
internal expect fun rememberWindowInsetsController(): WindowInsetsController?
