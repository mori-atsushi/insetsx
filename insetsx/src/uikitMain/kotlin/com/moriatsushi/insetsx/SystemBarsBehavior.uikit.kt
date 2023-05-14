package com.moriatsushi.insetsx

import platform.UIKit.UIRectEdge

/**
 * A class that represents options for behavior when system bars are hidden.
 */
actual class SystemBarsBehavior private constructor(
    internal val preferredScreenEdgesDeferringSystemGesturesWhenHidden: UIRectEdge,
) {
    actual companion object {
        /**
         * Default option to to remain interactive when hiding system bars.
         * The system bar can be revealed temporarily with system gestures,
         * but disappears after a period of time.
         */
        actual val Default: SystemBarsBehavior = SystemBarsBehavior(
            UIRectEdgeValue.None
        )

        /**
         * An immersive mode that limits user interaction when system bars are hidden.
         * The system bar can be revealed temporarily with system gestures,
         * but disappears after a period of time.
         */
        actual val Immersive: SystemBarsBehavior = SystemBarsBehavior(
            UIRectEdgeValue.All
        )
    }
}
