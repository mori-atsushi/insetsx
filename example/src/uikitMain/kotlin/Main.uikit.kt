import androidx.compose.ui.main.defaultUIKitMain
import com.moriatsushi.insetsx.WindowInsetsUIViewController
import com.moriatsushi.insetsx.example.ExampleApp

fun main() {
    defaultUIKitMain(
        "InsetsX",
        WindowInsetsUIViewController {
            ExampleApp()
        },
    )
}
