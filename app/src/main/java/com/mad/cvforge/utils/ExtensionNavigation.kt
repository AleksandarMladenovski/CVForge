package com.mad.cvforge.utils

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.mad.cvforge.navigation.TopLevelDestination

fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
