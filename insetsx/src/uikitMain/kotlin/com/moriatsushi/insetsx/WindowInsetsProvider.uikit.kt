package com.moriatsushi.insetsx

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import platform.UIKit.UIWindow

@Composable
fun WindowInsetsProvider(
    window: UIWindow,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalView provides window,
        content = content
    )
}
