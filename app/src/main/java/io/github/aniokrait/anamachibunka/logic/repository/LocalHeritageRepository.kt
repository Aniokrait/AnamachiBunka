package io.github.aniokrait.anamachibunka.logic.repository

import io.github.aniokrait.anamachibunka.logic.database.Heritage

interface LocalHeritageRepository {
    suspend fun getHeritages() : List<Heritage>
    suspend fun insert(heritage: Heritage)
    suspend fun insertAll(vararg heritage: Heritage)
}