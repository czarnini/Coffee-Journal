package com.boguckimi.coffeejournal.core.presentation.description

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DescriptionViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(Description.UiState())
    val uiState = _uiState.asStateFlow()


}