package com.moriatsushi.insetsx.example

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moriatsushi.insetsx.safeDrawing

@Composable
fun ExampleApp() {
    MaterialTheme {
        Scaffold(
            topBar = {
                ExampleTopAppBar()
            },
            bottomBar = {
                ExampleBottomAppBar()
            }
        ) {
            ExampleContent(
                modifier = Modifier.padding(it)
            )
        }
    }
}

@Composable
private fun ExampleTopAppBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier
            .background(MaterialTheme.colors.primarySurface)
            .windowInsetsPadding(
                WindowInsets.safeDrawing.only(WindowInsetsSides.Top + WindowInsetsSides.Horizontal)
            ),
        title = {
            Text("InsetsX")
        },
        elevation = 0.dp
    )
}

@Composable
private fun ExampleBottomAppBar(
    modifier: Modifier = Modifier,
) {
    BottomAppBar(
        modifier = modifier
            .background(MaterialTheme.colors.primarySurface)
            .windowInsetsPadding(
                WindowInsets.safeDrawing.only(
                    WindowInsetsSides.Bottom + WindowInsetsSides.Horizontal
                )
            ),
        elevation = 0.dp
    ) {
        IconButton(onClick = { /* no op */ }) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menu Button"
            )
        }
    }
}

@Composable
private fun ExampleContent(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.windowInsetsPadding(
            WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal)
        ),
        contentAlignment = Alignment.Center
    ) {
        Text("Content")
    }
}
