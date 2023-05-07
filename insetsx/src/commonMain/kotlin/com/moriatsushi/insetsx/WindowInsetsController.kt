package com.moriatsushi.insetsx

import androidx.compose.runtime.Composable

/**
 * A class which provides utilities for updating the system UI
 * such as the status bars and the navigation bars.
 */
interface WindowInsetsController {
    /**
     * The status bars icon + content will change to a dark color if [dark] is true.
     * This is appropriate when the background is light.
     *
     * * In Android: This setting is ignored on API <23.
     * * In iOS: Use with `WindowInsetsUIViewController`. If the current `UIViewController`
     * is not the main one in the window, this setting is ignored.
     */
    fun setStatusBarContentColor(dark: Boolean)

    /**
     * The navigation bars icons will change to a dark color if [dark] is true.
     * This is appropriate when the background is light.
     *
     * * In Android: This setting is ignored on API <26 or on the gesture
     * navigation mode.
     * * In iOS: This setting is ignored.
     */
    fun setNavigationBarsContentColor(dark: Boolean)
}

/**
 * Find and return a [WindowInsetsController].
 */
@Composable
expect fun rememberWindowInsetsController(): WindowInsetsController?
