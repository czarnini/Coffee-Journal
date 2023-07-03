package com.boguckimi.coffeejournal.core.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boguckimi.coffeejournal.core.presentation.description.Description
import com.boguckimi.coffeejournal.core.utils.navigation.extension.entryDataObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        savedStateHandle.entryDataObject<Details.EntryDataObject>().run {
            Details.UiState(
                productName = name,
                productId = "#$id",
                description = " - "
            )
        }
    )
    val uiState = _uiState.asStateFlow()

    fun onDescriptionResult(result: String) {
        _uiState.value = _uiState.value.copy(
            description = result
        )
    }
}
