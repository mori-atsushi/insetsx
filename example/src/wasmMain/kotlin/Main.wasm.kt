import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.moriatsushi.insetsx.example.ExampleApp

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow("InsetsX", canvasElementId = "canvas") {
        ExampleApp()
    }
}
