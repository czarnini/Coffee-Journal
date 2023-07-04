package com.boguckimi.coffeejournal.core.presentation.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.boguckimi.coffeejournal.core.presentation.details.Details
import com.boguckimi.coffeejournal.core.utils.navigation.Destination
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseResultDataObject
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.EmptyEntryDataObject
import com.boguckimi.coffeejournal.core.utils.navigation.extension.navigateTo
import kotlinx.serialization.Serializable

object ProductsList : Destination<EmptyEntryDataObject, ProductsList.ResultDataObject>() {

    override val route = "list"

    @Composable
    override fun Route(
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry,
    ) {

        val viewModel: ListViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsState()
        ListScreen(
            uiState = uiState,
            onListItemClicked = { entryDataObject ->
                navController.navigateTo(
                    destination = Details,
                    entryDataObject = entryDataObject,
                )
            }
        )
    }

    data class UiState(
        val items: MutableList<Pair<String, Int>>,
    )

    @Serializable
    object ResultDataObject : BaseResultDataObject()

}
