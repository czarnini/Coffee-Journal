package com.boguckimi.coffeejournal.core.utils.navigation.extension

import androidx.navigation.NavBackStackEntry
import com.boguckimi.coffeejournal.core.utils.navigation.Destination
import com.boguckimi.coffeejournal.core.utils.navigation.RESULT_DATA_OBJECT_KEY
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseResultDataObject
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Suppress("UNUSED_PARAMETER")
inline fun <reified RESULT : BaseResultDataObject> NavBackStackEntry.beBackWithDataFrom(
    destination: Destination<*, RESULT>,
    action: (RESULT) -> Unit
) {
    savedStateHandle
        .get<String>(RESULT_DATA_OBJECT_KEY)
        ?.let { action(Json.decodeFromString(it)) }
}
