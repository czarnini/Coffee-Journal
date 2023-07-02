package com.boguckimi.coffeejournal.core.utils.navigation.extension

import androidx.lifecycle.SavedStateHandle
import com.boguckimi.coffeejournal.core.utils.navigation.ENTRY_DATA_OBJECT_KEY
import com.boguckimi.coffeejournal.core.utils.navigation.NavTypeRegistry


/**
 * Retrieves the data object associated with a destination from the SavedStateHandle.
 *
 * @param T The type of data associated with the destination.
 * @return The data object associated with the destination, or an empty object if not found.
 */
inline fun <reified T> SavedStateHandle.entryDataObject() =
    NavTypeRegistry.getType<T>().parseValue(get<String>(ENTRY_DATA_OBJECT_KEY).orEmpty())
