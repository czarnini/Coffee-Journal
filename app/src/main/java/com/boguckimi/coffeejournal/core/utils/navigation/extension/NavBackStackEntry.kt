package com.boguckimi.coffeejournal.core.utils.navigation.extension

import androidx.navigation.NavBackStackEntry
import com.boguckimi.coffeejournal.core.utils.navigation.EmptyDestination
import com.boguckimi.coffeejournal.core.utils.navigation.RESULT_DATA_OBJECT_KEY
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseResultDataObject
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Suppress("UNUSED_PARAMETER")
inline fun <reified RESULT : BaseResultDataObject> NavBackStackEntry.checkResult(
    destination: EmptyDestination<RESULT>,
    onResult: (RESULT) -> Unit
) {
    savedStateHandle.get<String>(RESULT_DATA_OBJECT_KEY)?.let { serializedResult ->
        onResult(Json.decodeFromString(serializedResult))
    }
}
