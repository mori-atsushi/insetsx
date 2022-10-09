package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable

expect val WindowInsets.Companion.safeDrawing: WindowInsets
    @Composable get
