package com.boguckimi.coffeejournal.core.utils.navigation.extension

import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.boguckimi.coffeejournal.core.utils.navigation.Destination
import com.boguckimi.coffeejournal.core.utils.navigation.ENTRY_DATA_OBJECT_KEY
import com.boguckimi.coffeejournal.core.utils.navigation.NavTypeRegistry
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseEntryDataObject
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseResultDataObject
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.EmptyEntryDataObject


/**
 * Defines a destination in the navigation graph with the specified content.
 *
 * @param destination The destination object.
 */
inline fun <reified ENTRY : BaseEntryDataObject, reified RESULT : BaseResultDataObject> NavGraphBuilder.destination(
    navController: NavHostController,
    destination: Destination<ENTRY, RESULT>,
    deepLinks: List<NavDeepLink> = emptyList(),
) {
    composable(
        route = getRoute(destination),
        arguments = getArguments<ENTRY>(),
        content = { navBackStackEntry -> destination.Route(navController, navBackStackEntry) },
        deepLinks = deepLinks
    )
}

inline fun <reified ENTRY : BaseEntryDataObject> getArguments() = when {
    ENTRY::class == EmptyEntryDataObject::class -> emptyList()
    else -> listOf(navArgument(
        name = ENTRY_DATA_OBJECT_KEY,
        builder = { type = NavTypeRegistry.getType<ENTRY>() }
    ))
}

inline fun <reified ENTRY : BaseEntryDataObject, reified RESULT : BaseResultDataObject> getRoute(
    destination: Destination<ENTRY, RESULT>
) = when {
    ENTRY::class == EmptyEntryDataObject::class -> destination.route
    else -> "${destination.route}/{$ENTRY_DATA_OBJECT_KEY}"
}
