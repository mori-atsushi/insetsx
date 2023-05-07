package com.moriatsushi.insetsx

import androidx.core.view.WindowInsetsControllerCompat

/**
 * A class that represents options for behavior when system bars are hidden.
 */
actual class SystemBarsBehavior private constructor(
    internal val value: Int,
) {
    actual companion object {
        /**
         * Default option to to remain interactive when hiding system bars.
         * The system bars can be revealed with system gestures,
         * such as swiping from the edge.
         */
        actual val Default: SystemBarsBehavior = SystemBarsBehavior(
            WindowInsetsControllerCompat.BEHAVIOR_DEFAULT
        )

        /**
         * An immersive mode that limits user interaction when system bars are hidden.
         * The system bar can be revealed temporarily with system gestures,
         * but disappears after a period of time.
         */
        actual val Immersive: SystemBarsBehavior = SystemBarsBehavior(
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        )
    }
}
