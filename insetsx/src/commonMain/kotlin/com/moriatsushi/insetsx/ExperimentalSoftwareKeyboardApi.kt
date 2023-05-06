package com.moriatsushi.insetsx

/**
 * Mark declarations as experimental by the software keyboard.
 *
 * In iOS, software keyboard behavior is not yet complete.
 * Specifically, the window moves automatically when the focused element is
 * obscured by the keyboard, but we can't disable it.
 *
 * https://github.com/JetBrains/compose-multiplatform/issues/3128
 */
@MustBeDocumented
@Retention(value = AnnotationRetention.BINARY)
@RequiresOptIn(
    level = RequiresOptIn.Level.WARNING,
    message = "This API is experimental for the software keyboard."
)
annotation class ExperimentalSoftwareKeyboardApi
