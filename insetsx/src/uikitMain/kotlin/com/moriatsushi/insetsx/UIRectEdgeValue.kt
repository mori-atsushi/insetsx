package com.moriatsushi.insetsx

import platform.UIKit.UIRectEdge

internal object UIRectEdgeValue {
    val None: UIRectEdge = 0.toULong()
    val Top: UIRectEdge = (1 shl 0).toULong()
    val Left: UIRectEdge = (1 shl 1).toULong()
    val Bottom: UIRectEdge = (1 shl 2).toULong()
    val Right: UIRectEdge = (1 shl 3).toULong()
    val All: UIRectEdge = Top or Left or Bottom or Right
}
