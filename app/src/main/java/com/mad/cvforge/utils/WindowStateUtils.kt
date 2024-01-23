package com.mad.cvforge.utils

import android.graphics.Rect
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.window.layout.FoldingFeature
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

sealed interface DevicePosture {
    data object NormalPosture : DevicePosture

    data class BookPosture(
        val hingePosition: Rect
    ) : DevicePosture

    data class Separating(
        val hingePosition: Rect,
        var orientation: FoldingFeature.Orientation
    ) : DevicePosture
}


@OptIn(ExperimentalContracts::class)
fun isBookPosture(foldFeature: FoldingFeature?): Boolean {
    contract { returns(true) implies (foldFeature != null) }
    return foldFeature?.state == FoldingFeature.State.HALF_OPENED &&
            foldFeature.orientation == FoldingFeature.Orientation.VERTICAL
}

@OptIn(ExperimentalContracts::class)
fun isSeparating(foldFeature: FoldingFeature?): Boolean {
    contract { returns(true) implies (foldFeature != null) }
    return foldFeature?.state == FoldingFeature.State.FLAT && foldFeature.isSeparating
}

/**
 * Different type of navigation supported by app depending on size and state.
 */
enum class AdaptiveNavigationType {
    BOTTOM_NAVIGATION, NAVIGATION_RAIL, PERMANENT_NAVIGATION_DRAWER
}

/**
 * Content shown depending on size and state of device.
 */
enum class AdaptiveContentType {
    LIST_ONLY, LIST_AND_DETAIL
}

class AdaptiveLayout(
    windowSizeClass: WindowSizeClass,
    foldingDevicePosture: DevicePosture,
) {
    private val navigationType: AdaptiveNavigationType
    private val contentType: AdaptiveContentType

    init {
        when (windowSizeClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                navigationType = AdaptiveNavigationType.BOTTOM_NAVIGATION
                contentType = AdaptiveContentType.LIST_ONLY
            }

            WindowWidthSizeClass.Medium -> {
                navigationType = AdaptiveNavigationType.NAVIGATION_RAIL
                contentType = if (foldingDevicePosture != DevicePosture.NormalPosture) {
                    AdaptiveContentType.LIST_AND_DETAIL
                } else {
                    AdaptiveContentType.LIST_ONLY
                }
            }

            WindowWidthSizeClass.Expanded -> {
                navigationType = if (foldingDevicePosture is DevicePosture.BookPosture) {
                    AdaptiveNavigationType.NAVIGATION_RAIL
                } else {
                    AdaptiveNavigationType.NAVIGATION_RAIL
//                    AdaptiveNavigationType.PERMANENT_NAVIGATION_DRAWER
                }
                contentType = AdaptiveContentType.LIST_AND_DETAIL
            }

            else -> {
                navigationType = AdaptiveNavigationType.BOTTOM_NAVIGATION
                contentType = AdaptiveContentType.LIST_ONLY
            }
        }
    }

    fun shouldShowBottomBar() = navigationType == AdaptiveNavigationType.BOTTOM_NAVIGATION
    fun shouldShowNavRail() = navigationType == AdaptiveNavigationType.NAVIGATION_RAIL
    fun shouldShowNavDrawer() = navigationType == AdaptiveNavigationType.PERMANENT_NAVIGATION_DRAWER

    fun isOnePageLayout() = contentType == AdaptiveContentType.LIST_ONLY
    fun isTwoPageLayout() = contentType == AdaptiveContentType.LIST_AND_DETAIL

}