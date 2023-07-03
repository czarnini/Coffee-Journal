package com.boguckimi.coffeejournal.core.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailsScreen(
    uiState: Details.UiState,
    onEditDescriptionClicked: () -> Unit,
) {
    Column {
        Text("Product name: ${uiState.productName}")
        Text("Product id: ${uiState.productId}")
        Text("Description: ${uiState.description}")

        Button(
            onClick = onEditDescriptionClicked
        ) {
            Text("Edit Description")
        }
    }
}