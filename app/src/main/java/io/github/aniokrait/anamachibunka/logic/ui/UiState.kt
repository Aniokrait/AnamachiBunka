package io.github.aniokrait.anamachibunka.logic.ui

import io.github.aniokrait.anamachibunka.logic.hilt.data.Heritage

data class UiState(
    val heritages: List<Heritage> = mutableListOf()
)