package com.moriatsushi.insetsx

/**
 * No operation.
 */
actual class SystemBarsBehavior {
    actual companion object {
        private val instance = SystemBarsBehavior()

        /**
         * No operation.
         */
        actual val Default: SystemBarsBehavior = instance

        /**
         * No operation.
         */
        actual val Immersive: SystemBarsBehavior = instance
    }
}
