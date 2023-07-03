package com.boguckimi.coffeejournal.core.utils.navigation.extension

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.boguckimi.coffeejournal.core.utils.navigation.Destination
import com.boguckimi.coffeejournal.core.utils.navigation.ENTRY_DATA_OBJECT_KEY
import com.boguckimi.coffeejournal.core.utils.navigation.EmptyDestination
import com.boguckimi.coffeejournal.core.utils.navigation.NavTypeRegistry
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseEntryDataObject
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseResultDataObject


/**
 * Defines a destination in the navigation graph with the specified content.
 *
 * @param destination The destination object.
 */
inline fun <reified ENTRY : BaseEntryDataObject, reified RESULT : BaseResultDataObject> NavGraphBuilder.destination(
    navController: NavHostController,
    destination: Destination<ENTRY, RESULT>,
) {
    composable(
        route = "${destination.route}/{$ENTRY_DATA_OBJECT_KEY}",
        arguments = listOf(
            navArgument(
                name = ENTRY_DATA_OBJECT_KEY,
                builder = { type = NavTypeRegistry.getType<ENTRY>() }
            )
        ),
        content = { navBackStackEntry -> destination.Route(navController, navBackStackEntry) }
    )
}


/**
 * Defines an empty destination in the navigation graph with the specified content.
 *
 * @param destination The empty destination object.
 */
inline fun <reified RESULT : BaseResultDataObject> NavGraphBuilder.emptyDestination(
    navController: NavHostController,
    destination: EmptyDestination<RESULT>,
) {
    composable(
        route = destination.route,
        content = { navBackStackEntry -> destination.Route(navController, navBackStackEntry) },
    )
}