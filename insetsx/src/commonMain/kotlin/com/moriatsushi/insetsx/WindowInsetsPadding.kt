package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

@ExperimentalSoftwareKeyboardApi
fun Modifier.safeDrawingPadding() = Modifier.windowInsetsPadding {
    WindowInsets.safeDrawing
}

fun Modifier.systemBarsPadding() = Modifier.windowInsetsPadding {
    WindowInsets.systemBars
}

fun Modifier.statusBarsPadding() = Modifier.windowInsetsPadding {
    WindowInsets.statusBars
}

@ExperimentalSoftwareKeyboardApi
fun Modifier.imePadding() = Modifier.windowInsetsPadding {
    WindowInsets.ime
}

fun Modifier.navigationBarsPadding() = Modifier.windowInsetsPadding {
    WindowInsets.navigationBars
}

private inline fun Modifier.windowInsetsPadding(
    crossinline block: @Composable () -> WindowInsets,
): Modifier = composed {
    Modifier.windowInsetsPadding(block())
}
