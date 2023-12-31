package com.boguckimi.coffeejournal.core.utils.navigation.extension

import androidx.navigation.NavHostController
import com.boguckimi.coffeejournal.core.utils.navigation.Destination
import com.boguckimi.coffeejournal.core.utils.navigation.NavTypeRegistry
import com.boguckimi.coffeejournal.core.utils.navigation.RESULT_DATA_OBJECT_KEY
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseEntryDataObject
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseResultDataObject
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.EmptyEntryDataObject
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Navigates to a destination in the navigation graph with the specified data.
 *
 * @param destination The destination to navigate to.
 * @param entryDataObject The data object associated with the destination.
 */
inline fun <reified ENTRY : BaseEntryDataObject, reified RESULT : BaseResultDataObject> NavHostController.navigateTo(
    destination: Destination<ENTRY, RESULT>,
    entryDataObject: ENTRY,
) = navigate(
    route = "${destination.route}/${
        NavTypeRegistry.getType<ENTRY>().serializeAsValue(entryDataObject)
    }"
)

/**
 * Navigates to a destination in the navigation graph with [EmptyEntryDataObject]
 *
 * @param destination The destination to navigate to.
 */
inline fun <reified RESULT : BaseResultDataObject> NavHostController.navigateTo(
    destination: Destination<EmptyEntryDataObject, RESULT>,
) = navigate(route = destination.route)

inline fun <reified T> NavHostController.finishWihResult(result: T) {
    previousBackStackEntry?.savedStateHandle?.set(
        key = RESULT_DATA_OBJECT_KEY,
        value = Json.encodeToString(result)
    )
    popBackStack()
}
