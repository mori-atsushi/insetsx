package com.moriatsushi.insetsx

import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val name: String = """
        ${UIDevice.currentDevice.systemName()} ${UIDevice.currentDevice.systemVersion}
    """.trimIndent()
}

actual fun getPlatform(): Platform = IOSPlatform()
