package com.moriatsushi.insetsx

/**
 * No operation. Desktop has no window insets.
 */
actual class SystemBarsBehavior {
    actual companion object {
        private val instance = SystemBarsBehavior()

        /**
         * No operation. Desktop has no window insets.
         */
        actual val Default: SystemBarsBehavior = instance

        /**
         * No operation. Desktop has no window insets.
         */
        actual val Immersive: SystemBarsBehavior = instance
    }
}
