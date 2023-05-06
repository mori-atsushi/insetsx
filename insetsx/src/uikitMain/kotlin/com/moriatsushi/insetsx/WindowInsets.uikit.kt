package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable

actual val WindowInsets.Companion.navigationBars: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().navigationBars

actual val WindowInsets.Companion.statusBars: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().statusBars

actual val WindowInsets.Companion.systemBars: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().systemBars

actual val WindowInsets.Companion.ime: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().ime

actual val WindowInsets.Companion.safeDrawing: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().safeDrawing
