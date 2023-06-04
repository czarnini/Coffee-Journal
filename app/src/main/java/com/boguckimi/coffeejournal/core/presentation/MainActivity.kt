package com.boguckimi.coffeejournal.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.boguckimi.coffeejournal.core.ui.theme.CoffeeJournalTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeJournalTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = "Hello Coffee")
                }
            }
        }
    }
}

