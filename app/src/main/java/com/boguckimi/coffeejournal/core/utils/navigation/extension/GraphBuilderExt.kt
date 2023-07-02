package com.boguckimi.coffeejournal.core.utils.navigation.extension

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.boguckimi.coffeejournal.core.utils.navigation.Destination
import com.boguckimi.coffeejournal.core.utils.navigation.ENTRY_DATA_OBJECT_KEY
import com.boguckimi.coffeejournal.core.utils.navigation.EmptyDestination
import com.boguckimi.coffeejournal.core.utils.navigation.NavTypeRegistry


/**
 * Defines a destination in the navigation graph with the specified content.
 *
 * @param destination The destination object.
 */
inline fun <reified T> NavGraphBuilder.destination(
    navController: NavHostController,
    destination: Destination<T>,
) {
    composable(
        route = "${destination.route}/{$ENTRY_DATA_OBJECT_KEY}",
        arguments = listOf(
            navArgument(
                name = ENTRY_DATA_OBJECT_KEY,
                builder = { type = NavTypeRegistry.getType<T>() }
            )
        ),
        content = { destination.Route(navController) }
    )
}


/**
 * Defines an empty destination in the navigation graph with the specified content.
 *
 * @param destination The empty destination object.
 */
fun NavGraphBuilder.emptyDestination(
    navController: NavHostController,
    destination: EmptyDestination,
) {
    composable(
        route = destination.route,
        content = { destination.Route(navController) },
    )
}