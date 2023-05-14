package com.moriatsushi.insetsx

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.ComposeUIViewController
import com.moriatsushi.insetsx.cinterop.UIViewControllerWithOverridesProtocol
import platform.Foundation.NSCoder
import platform.UIKit.UIRectEdge
import platform.UIKit.UIStatusBarStyle
import platform.UIKit.UIView
import platform.UIKit.UIViewAutoresizingFlexibleHeight
import platform.UIKit.UIViewAutoresizingFlexibleWidth
import platform.UIKit.UIViewController
import platform.UIKit.addChildViewController
import platform.UIKit.didMoveToParentViewController
import platform.UIKit.setNeedsUpdateOfHomeIndicatorAutoHidden
import platform.UIKit.setNeedsUpdateOfScreenEdgesDeferringSystemGestures

/**
 * Create a [UIViewController] with window insets support
 */
@Suppress("FunctionName")
fun WindowInsetsUIViewController(content: @Composable () -> Unit): UIViewController =
    WindowInsetsUIViewController().apply {
        setContent(content)
    }

internal class WindowInsetsUIViewController :
    UIViewController,
    UIViewControllerWithOverridesProtocol {
    @OverrideInit
    constructor() : super(nibName = null, bundle = null)

    @OverrideInit
    constructor(coder: NSCoder) : super(coder)

    private lateinit var content: @Composable () -> Unit

    private var _preferredStatusBarStyle: UIStatusBarStyle = 0L
    override fun preferredStatusBarStyle(): UIStatusBarStyle =
        _preferredStatusBarStyle

    private var _prefersStatusBarHidden: Boolean = false
    override fun prefersStatusBarHidden(): Boolean =
        _prefersStatusBarHidden

    private var _prefersHomeIndicatorAutoHidden: Boolean = false
    override fun prefersHomeIndicatorAutoHidden(): Boolean =
        _prefersHomeIndicatorAutoHidden

    private var _preferredScreenEdgesDeferringSystemGestures: UIRectEdge = UIRectEdgeValue.None
    override fun preferredScreenEdgesDeferringSystemGestures(): UIRectEdge =
        _preferredScreenEdgesDeferringSystemGestures

    private val windowInsetsController = object : WindowInsetsController {
        private var preferredScreenEdgesDeferringSystemGesturesWhenHidden: UIRectEdge =
            UIRectEdgeValue.None

        override fun setStatusBarContentColor(dark: Boolean) {
            _preferredStatusBarStyle = if (dark) 3L else 1L
            setNeedsStatusBarAppearanceUpdate()
        }

        override fun setNavigationBarsContentColor(dark: Boolean) {
            // no op
        }

        override fun setIsStatusBarsVisible(isVisible: Boolean) {
            _prefersStatusBarHidden = !isVisible
            setNeedsStatusBarAppearanceUpdate()
            applyScreenEdgesDeferringSystemGestures()
        }

        override fun setIsNavigationBarsVisible(isVisible: Boolean) {
            _prefersHomeIndicatorAutoHidden = !isVisible
            setNeedsUpdateOfHomeIndicatorAutoHidden()
            applyScreenEdgesDeferringSystemGestures()
        }

        override fun setSystemBarsBehavior(behavior: SystemBarsBehavior) {
            preferredScreenEdgesDeferringSystemGesturesWhenHidden =
                behavior.preferredScreenEdgesDeferringSystemGesturesWhenHidden
            applyScreenEdgesDeferringSystemGestures()
        }

        private fun applyScreenEdgesDeferringSystemGestures() {
            _preferredScreenEdgesDeferringSystemGestures =
                if (_prefersHomeIndicatorAutoHidden || _prefersStatusBarHidden) {
                    preferredScreenEdgesDeferringSystemGesturesWhenHidden
                } else {
                    UIRectEdgeValue.None
                }
            setNeedsUpdateOfScreenEdgesDeferringSystemGestures()
        }
    }

    override fun loadView() {
        super.loadView()

        val rootView = UIView()
        val composeViewController = ComposeUIViewController {
            CompositionLocalProvider(
                LocalWindowInsetsController provides windowInsetsController,
                content = content
            )
        }
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
