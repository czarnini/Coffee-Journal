package com.boguckimi.coffeejournal.core.presentation.description

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescriptionScreen(
    uiState: Description.UiState,
    onSaveClicked: (String) -> Unit = {},
    onCancelClicked: () -> Unit = {},
) {
    Column {
        Button(
            onClick = { onSaveClicked("Hello From Description") }
        ) {
            Text("SAVE")
        }

        Button(onCancelClicked) {
            Text("CANCEL")
        }
    }

}
