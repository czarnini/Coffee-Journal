package com.boguckimi.coffeejournal.core.utils.navigation

import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseEntryDataObject
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseResultDataObject

/**
 * An abstract class representing a destination in the navigation graph.
 *
 * @param ENTRY The type of data associated with the destination.
 */
abstract class Destination<ENTRY: BaseEntryDataObject, RESULT : BaseResultDataObject> : EmptyDestination<RESULT>
