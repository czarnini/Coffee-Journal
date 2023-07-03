package com.boguckimi.coffeejournal.core.utils.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseResultDataObject


/**
 * Represents an empty destination in the navigation graph.
 */
interface EmptyDestination <RESULT : BaseResultDataObject> {
    /**
     * Returns the route associated with this empty destination.
     */
    val route: String

    @Composable
    fun Route(navController: NavHostController, navBackStackEntry: NavBackStackEntry)
}