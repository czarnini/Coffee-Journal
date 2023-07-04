package com.boguckimi.coffeejournal.core.presentation.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.boguckimi.coffeejournal.core.presentation.description.Description
import com.boguckimi.coffeejournal.core.utils.navigation.Destination
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseEntryDataObject
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseResultDataObject
import com.boguckimi.coffeejournal.core.utils.navigation.extension.beBackWithDataFrom
import com.boguckimi.coffeejournal.core.utils.navigation.extension.navigateTo
import kotlinx.serialization.Serializable

object Details : Destination<Details.EntryDataObject, Details.ResultDataObject>() {

    override val route = "details"

    @Composable
    override fun Route(
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry,
    ) {
        val viewModel: DetailsViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsState()

        navBackStackEntry.beBackWithDataFrom(
            destination = Description,
            action = { viewModel.onDescriptionResult(it.result) }
        )

        DetailsScreen(
            uiState = uiState,
            onEditDescriptionClicked = { navController.navigateTo(Description) }
        )
    }

    data class UiState(
        val productName: String,
        val productId: String,
        val description: String
    )

    @Serializable
    data class EntryDataObject(
        val id: Int,
        val name: String,
    ) : BaseEntryDataObject()

    @Serializable
    object ResultDataObject : BaseResultDataObject()
}
