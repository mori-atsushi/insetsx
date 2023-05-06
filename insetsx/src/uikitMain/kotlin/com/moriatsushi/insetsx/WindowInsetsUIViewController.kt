package com.moriatsushi.insetsx

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.useContents
import platform.Foundation.NSCoder
import platform.UIKit.UIView
import platform.UIKit.UIViewAutoresizingFlexibleHeight
import platform.UIKit.UIViewAutoresizingFlexibleWidth
import platform.UIKit.UIViewController
import platform.UIKit.addChildViewController
import platform.UIKit.didMoveToParentViewController

/**
 * Create a [UIViewController] with window insets support
 */
@Suppress("FunctionName")
fun WindowInsetsUIViewController(content: @Composable () -> Unit): UIViewController =
    WindowInsetsUIViewController().apply {
        setContent(content)
    }

private class WindowInsetsUIViewController : UIViewController {
    @OverrideInit
    constructor() : super(nibName = null, bundle = null)

    @OverrideInit
    constructor(coder: NSCoder) : super(coder)

    private lateinit var content: @Composable () -> Unit

    override fun loadView() {
        super.loadView()

        val rootView = UIView()
        val composeViewController = ComposeUIViewController(content)
        addChildViewController(composeViewController)
        rootView.addSubview(composeViewController.view)
        rootView.setAutoresizesSubviews(true)
        composeViewController.view.setAutoresizingMask(
            UIViewAutoresizingFlexibleWidth or UIViewAutoresizingFlexibleHeight
        )
        view = rootView
        composeViewController.didMoveToParentViewController(this)
    }

    fun setContent(
        content: @Composable () -> Unit,
    ) {
        this.content = content
    }
}
