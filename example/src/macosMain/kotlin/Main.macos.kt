import androidx.compose.ui.window.Window
import com.moriatsushi.insetsx.example.ExampleApp
import platform.AppKit.NSApp
import platform.AppKit.NSApplication

fun main() {
    NSApplication.sharedApplication()
    Window("Chat App") {
        ExampleApp()
    }
    NSApp?.run()
}
