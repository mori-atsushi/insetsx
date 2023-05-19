import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.moriatsushi.insetsx.example.ExampleApp

fun main() = application {
    Window(
        title = "InsetsX",
        state = rememberWindowState(width = 600.dp, height = 800.dp),
        onCloseRequest = ::exitApplication
    ) {
        ExampleApp()
    }
}
