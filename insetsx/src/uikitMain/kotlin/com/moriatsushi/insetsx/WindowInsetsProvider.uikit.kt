package com.moriatsushi.insetsx

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import platform.UIKit.UIWindow
import platform.UIKit.addSubview
import platform.UIKit.removeFromSuperview

@Composable
fun WindowInsetsProvider(
    window: UIWindow,
    content: @Composable () -> Unit,
) {
    val windowInsetsHolder = remember(window) {
        WindowInsetsHolder(window.bounds).apply {
            window.addSubview(this)
        }
    }

    DisposableEffect(windowInsetsHolder) {
        onDispose {
            windowInsetsHolder.removeFromSuperview()
        }
    }

    CompositionLocalProvider(
        LocalWindowInsetsHolder provides windowInsetsHolder,
        content = content
    )
}
