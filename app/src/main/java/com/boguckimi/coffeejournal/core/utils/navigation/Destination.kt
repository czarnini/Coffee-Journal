package com.boguckimi.coffeejournal.core.utils.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseEntryDataObject
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseResultDataObject

/**
 * An abstract class representing a destination in the navigation graph.
 *
 * @param ENTRY The type of data associated with the destination.
 */
abstract class Destination<ENTRY : BaseEntryDataObject, RESULT : BaseResultDataObject> {

    abstract val route: String

    @Composable
    abstract fun Route(navController: NavHostController, navBackStackEntry: NavBackStackEntry)
}
