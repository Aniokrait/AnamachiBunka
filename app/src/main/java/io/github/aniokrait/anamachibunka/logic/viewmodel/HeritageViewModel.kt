package io.github.aniokrait.anamachibunka.logic.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.aniokrait.anamachibunka.logic.database.Heritage
import io.github.aniokrait.anamachibunka.logic.dataclass.HeritageUiModel
import io.github.aniokrait.anamachibunka.logic.usecase.GetHeritageUseCase
import io.github.aniokrait.anamachibunka.logic.usecase.GetNearHeritagesUseCase
import io.github.aniokrait.anamachibunka.ui.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HeritageViewModel @Inject constructor(
    private val getNearHeritagesUseCase: GetNearHeritagesUseCase,
    private val getHeritageUseCase: GetHeritageUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _heritageDetailState = MutableStateFlow(
        HeritageUiModel(id = 0, name = "", longitude = 0.0, latitude = 0.0))
    val heritageDetailState: StateFlow<HeritageUiModel> = _heritageDetailState.asStateFlow()

    fun getHeritages() {
        CoroutineScope(Dispatchers.IO).launch {
            val heritages = getNearHeritagesUseCase()
            _uiState.value = UiState(heritages)
        }
    }

    fun getHeritageById(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val heritage = getHeritageUseCase(id)
            _heritageDetailState.value = heritage
        }
    }

    fun insertTestDate(heritage: Heritage) {
        CoroutineScope(Dispatchers.IO).launch {
//            heritageRepository.insert(heritage)

        }
    }
}