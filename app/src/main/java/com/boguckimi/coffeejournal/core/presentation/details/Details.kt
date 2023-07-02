package com.boguckimi.coffeejournal.core.presentation.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.boguckimi.coffeejournal.core.utils.navigation.Destination
import kotlinx.serialization.Serializable

object Details : Destination<Details.EntryDataObject>() {

    override val route = "details"


    @Composable
    override fun Route(
        navController: NavHostController,
    ) {
        val viewModel: DetailsViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsState()

        DetailsScreen(
            uiState = uiState
        )
    }


    @Serializable
    data class EntryDataObject(
        val id: Int,
        val name: String,
    )
}
