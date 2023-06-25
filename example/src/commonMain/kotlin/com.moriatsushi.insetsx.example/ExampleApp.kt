package com.moriatsushi.insetsx.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.moriatsushi.insetsx.ExperimentalSoftwareKeyboardApi
import com.moriatsushi.insetsx.imePadding
import com.moriatsushi.insetsx.rememberWindowInsetsController
import com.moriatsushi.insetsx.systemBars

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ExampleApp() {
    val windowInsetsController = rememberWindowInsetsController()
    LaunchedEffect(Unit) {
        windowInsetsController?.apply {
            setStatusBarContentColor(dark = true)
            setNavigationBarsContentColor(dark = true)
        }
    }

    MaterialTheme {
        Scaffold(
            topBar = {
                ExampleTopAppBar()
            },
            bottomBar = {
                ExampleBottomAppBar()
            },
            contentWindowInsets = WindowInsets.systemBars
        ) {
            ExampleContent(
                modifier = Modifier
                    .padding(it)
                    .consumeWindowInsets(it)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ExampleTopAppBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = { Text("InsetsX") },
        windowInsets = WindowInsets.systemBars.only(
            WindowInsetsSides.Top + WindowInsetsSides.Horizontal
        )
    )
}

@Composable
private fun ExampleBottomAppBar(
    modifier: Modifier = Modifier,
) {
    BottomAppBar(
        modifier = modifier,
        windowInsets = WindowInsets.systemBars.only(
            WindowInsetsSides.Bottom + WindowInsetsSides.Horizontal
        )
    ) {
        IconButton(onClick = { /* no op */ }) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menu Button"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSoftwareKeyboardApi::class)
@Composable
private fun ExampleContent(
    modifier: Modifier = Modifier,
) {
    var text by remember { mutableStateOf("") }
    Box(
        modifier = modifier
            .fillMaxSize()
            .imePadding(),
        contentAlignment = Alignment.Center
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { Text("Text Field") },
        )
    }
}
