package com.boguckimi.coffeejournal.core.utils.navigation.extension

import androidx.navigation.NavHostController
import com.boguckimi.coffeejournal.core.utils.navigation.Destination
import com.boguckimi.coffeejournal.core.utils.navigation.EmptyDestination
import com.boguckimi.coffeejournal.core.utils.navigation.NavTypeRegistry

/**
 * Navigates to a destination in the navigation graph with the specified data.
 *
 * @param destination The destination to navigate to.
 * @param entryDataObject The data object associated with the destination.
 */
inline fun <reified T> NavHostController.navigateTo(
    destination: Destination<T>,
    entryDataObject: T
) = navigate(route = "${destination.route}/${NavTypeRegistry.getType<T>().serializeAsValue(entryDataObject)}")


/**
 * Navigates to an empty destination in the navigation graph.
 *
 * @param destination The empty destination to navigate to.
 */
fun NavHostController.navigateTo(destination: EmptyDestination) = navigate(
    route = destination.route
)
