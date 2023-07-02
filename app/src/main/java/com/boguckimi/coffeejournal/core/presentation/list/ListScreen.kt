package com.boguckimi.coffeejournal.core.presentation.list

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.boguckimi.coffeejournal.core.presentation.details.Details

@Composable
fun ListScreen(
    onListItemClicked: (Details.EntryDataObject) -> Unit = {}
) {
    Column {
        repeat(5) {
            Button(
                onClick = { onListItemClicked(Details.EntryDataObject(it, "abc_$it")) },
                content = { Text(text = "Hello $it") }
            )
        }
    }
}
