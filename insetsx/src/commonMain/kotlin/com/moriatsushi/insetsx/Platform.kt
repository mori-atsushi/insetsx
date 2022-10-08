package com.moriatsushi.insetsx

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform