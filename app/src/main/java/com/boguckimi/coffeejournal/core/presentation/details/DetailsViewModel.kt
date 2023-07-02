package com.boguckimi.coffeejournal.core.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.boguckimi.coffeejournal.core.utils.navigation.extension.entryDataObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _uiState = MutableStateFlow(savedStateHandle.entryDataObject<Details.EntryDataObject>())
    val uiState = _uiState.asStateFlow()

}
