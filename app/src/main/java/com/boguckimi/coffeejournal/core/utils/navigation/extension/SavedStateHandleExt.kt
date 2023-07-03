package com.boguckimi.coffeejournal.core.utils.navigation.extension

import androidx.lifecycle.SavedStateHandle
import com.boguckimi.coffeejournal.core.utils.navigation.ENTRY_DATA_OBJECT_KEY
import com.boguckimi.coffeejournal.core.utils.navigation.NavTypeRegistry
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseEntryDataObject


/**
 * Retrieves the data object associated with a destination from the SavedStateHandle.
 *
 * @param ENTRY The type of data associated with the destination.
 * @return The data object associated with the destination, or an empty object if not found.
 */
inline fun <reified ENTRY : BaseEntryDataObject> SavedStateHandle.entryDataObject() =
    NavTypeRegistry.getType<ENTRY>().parseValue(get<String>(ENTRY_DATA_OBJECT_KEY).orEmpty())
