package io.github.aniokrait.anamachibunka.logic.repository

import io.github.aniokrait.anamachibunka.logic.hilt.data.Heritage
import io.github.aniokrait.anamachibunka.logic.hilt.data.HeritageDao

interface HeritageRepository {
    suspend fun getHeritages() : List<Heritage>
    suspend fun insert(heritage: Heritage)
}