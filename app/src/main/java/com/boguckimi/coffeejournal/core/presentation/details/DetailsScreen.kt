package com.boguckimi.coffeejournal.core.presentation.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailsScreen(
    uiState: Details.EntryDataObject
) {
    Text(text = "Details: $uiState")
}