package io.github.aniokrait.anamachibunka.ui

import io.github.aniokrait.anamachibunka.logic.database.Heritage
import io.github.aniokrait.anamachibunka.logic.dataclass.HeritageUiModel

data class UiState(
    val heritages: List<HeritageUiModel> = mutableListOf()
)