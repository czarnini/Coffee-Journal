package com.boguckimi.coffeejournal.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.boguckimi.coffeejournal.core.presentation.details.Details
import com.boguckimi.coffeejournal.core.presentation.list.List
import com.boguckimi.coffeejournal.core.ui.theme.CoffeeJournalTheme
import com.boguckimi.coffeejournal.core.utils.navigation.extension.destination
import com.boguckimi.coffeejournal.core.utils.navigation.extension.emptyDestination
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeJournalTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(navController, List.route) {
                        emptyDestination(navController, List)
                        destination(navController, Details)
                    }
                }
            }
        }
    }
}

