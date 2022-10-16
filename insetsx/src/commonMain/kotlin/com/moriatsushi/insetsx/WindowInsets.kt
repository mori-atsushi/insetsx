package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable

expect val WindowInsets.Companion.navigationBars: WindowInsets
    @Composable get

expect val WindowInsets.Companion.statusBars: WindowInsets
    @Composable get

expect val WindowInsets.Companion.systemBars: WindowInsets
    @Composable get

expect val WindowInsets.Companion.ime: WindowInsets
    @Composable get

expect val WindowInsets.Companion.safeDrawing: WindowInsets
    @Composable get
