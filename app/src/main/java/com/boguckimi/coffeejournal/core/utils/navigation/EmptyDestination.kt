package com.boguckimi.coffeejournal.core.utils.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


/**
 * Represents an empty destination in the navigation graph.
 */
interface EmptyDestination {
    /**
     * Returns the route associated with this empty destination.
     */
    val route: String

    @Composable
    abstract  fun Route(navController: NavHostController)
}