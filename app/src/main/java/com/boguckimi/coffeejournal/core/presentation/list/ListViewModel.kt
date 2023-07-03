package com.boguckimi.coffeejournal.core.presentation.list

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(
        ProductsList.UiState(
            items = mutableListOf(
                "Product 1" to 1,
                "Product 2" to 2,
                "Product 3" to 3,
                "Product 4" to 4,
            )
        )
    )
    val uiState = _uiState.asStateFlow()



}