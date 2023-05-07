package com.moriatsushi.insetsx

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private class AndroidWindowInsetsController(
    private val systemUiController: SystemUiController
) : WindowInsetsController {
    override fun setStatusBarContentColor(dark: Boolean) {
        systemUiController.statusBarDarkContentEnabled = dark
    }
}

@Composable
internal actual fun rememberWindowInsetsController(): WindowInsetsController? {
    val systemUIController = rememberSystemUiController()
    return remember {
        AndroidWindowInsetsController(systemUIController)
    }
}
