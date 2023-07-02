package com.boguckimi.coffeejournal.core.presentation.list

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.boguckimi.coffeejournal.core.presentation.details.Details
import com.boguckimi.coffeejournal.core.utils.navigation.EmptyDestination
import com.boguckimi.coffeejournal.core.utils.navigation.extension.navigateTo

object List : EmptyDestination {

    override val route = "list"

    @Composable
    override fun Route(
        navController: NavHostController,
    ) {
        val viewModel: ListViewModel = hiltViewModel()

        ListScreen(onListItemClicked = { entryDataObject ->
            navController.navigateTo(
                destination = Details,
                entryDataObject = entryDataObject,
            )
        })
    }
}
