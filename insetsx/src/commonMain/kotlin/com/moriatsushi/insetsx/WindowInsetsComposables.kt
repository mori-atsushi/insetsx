package com.moriatsushi.insetsx

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

/**
 * The status bars icon + content will change to a dark color if [dark] is true.
 * This is appropriate when the background is light.
 *
 * * In Android: This setting is ignored on API <23.
 * * In iOS: Use with `WindowInsetsUIViewController`. If the current `UIViewController`
 * is not the main one in the window, this setting is ignored.
 */
@Composable
fun StatusBarsContentColor(dark: Boolean) {
    val windowInsetsController = rememberWindowInsetsController()
    LaunchedEffect(dark) {
        windowInsetsController?.setStatusBarContentColor(dark)
    }
}

/**
 * The navigation bars icons will change to a dark color if [dark] is true.
 * This is appropriate when the background is light.
 *
 * * In Android: This setting is ignored on API <26 or on the gesture
 * navigation mode.
 * * In iOS: This setting is ignored.
 */
@Composable
fun NavigationBarsContentColor(dark: Boolean) {
    val windowInsetsController = rememberWindowInsetsController()
    LaunchedEffect(dark) {
        windowInsetsController?.setNavigationBarsContentColor(dark)
    }
}
