package com.boguckimi.coffeejournal.core.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.boguckimi.coffeejournal.core.presentation.details.Details

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    uiState: ProductsList.UiState,
    onListItemClicked: (Details.EntryDataObject) -> Unit = {}
) {
    LazyColumn {
        items(uiState.items) { (name, id) ->
            ListItem(
                modifier = Modifier.clickable {
                    onListItemClicked(
                        Details.EntryDataObject(
                            id = id,
                            name = name,
                        )
                    )
                },
                headlineText = { Text(name) },
            )
        }
    }
}
