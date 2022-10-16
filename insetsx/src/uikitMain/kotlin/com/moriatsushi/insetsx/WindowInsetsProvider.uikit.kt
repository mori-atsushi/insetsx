package com.moriatsushi.insetsx

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import platform.UIKit.UIWindow
import platform.UIKit.addSubview
import platform.UIKit.removeFromSuperview

@Composable
fun WindowInsetsProvider(
    window: UIWindow,
    content: @Composable () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val windowInsetsHolder = remember(window) {
        WindowInsetsHolder(window.bounds, scope).apply {
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
