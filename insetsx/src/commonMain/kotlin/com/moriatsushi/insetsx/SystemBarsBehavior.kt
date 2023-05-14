package com.moriatsushi.insetsx

/**
 * A class that represents options for behavior when system bars are hidden.
 */
expect class SystemBarsBehavior {
    companion object {
        /**
         * Default option to to remain interactive when hiding system bars.
         *
         * * In Android: The system bars can be revealed with system gestures,
         * such as swiping from the edge.
         * * In iOS: The system bar can be revealed temporarily with system gestures,
         * but disappears after a period of time.
         */
        val Default: SystemBarsBehavior

        /**
         * An immersive mode that limits user interaction when system bars are hidden.
         * The system bar can be revealed temporarily with system gestures,
         * but disappears after a period of time.
         */
        val Immersive: SystemBarsBehavior
    }
}
