package io.github.aniokrait.anamachibunka.logic.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.aniokrait.anamachibunka.logic.database.Heritage
import io.github.aniokrait.anamachibunka.ui.UiState
import io.github.aniokrait.anamachibunka.logic.usecase.GetNearHeritagesUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeritageViewModel @Inject constructor(
//    private val heritageRepository: HeritageRepository,
    private val getNearHeritagesUseCase: GetNearHeritagesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun getHeritages() {
        CoroutineScope(Dispatchers.IO).launch {
            val heritages = getNearHeritagesUseCase()
            _uiState.value = UiState(heritages)
        }
    }

    fun insertTestDate(heritage: Heritage) {
        CoroutineScope(Dispatchers.IO).launch {
//            heritageRepository.insert(heritage)

        }
    }
}