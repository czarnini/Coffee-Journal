package com.boguckimi.coffeejournal.core.presentation.description

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.boguckimi.coffeejournal.core.utils.navigation.Destination
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.BaseResultDataObject
import com.boguckimi.coffeejournal.core.utils.navigation.baseDataObject.EmptyEntryDataObject
import com.boguckimi.coffeejournal.core.utils.navigation.extension.finishWihResult
import kotlinx.serialization.Serializable

object Description : Destination<EmptyEntryDataObject, Description.ResultDataObject>() {
    override val route = "description"

    @Composable
    override fun Route(
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry,
    ) {
        val uiState by hiltViewModel<DescriptionViewModel>().uiState.collectAsState()

        DescriptionScreen(
            uiState = uiState,
            onSaveClicked = { navController.finishWihResult(ResultDataObject(it)) },
            onCancelClicked = navController::popBackStack
        )
    }

    data class UiState(
        val text: String = "",
    )

    @Serializable
    data class ResultDataObject(
        val result: String
    ) : BaseResultDataObject()
}
