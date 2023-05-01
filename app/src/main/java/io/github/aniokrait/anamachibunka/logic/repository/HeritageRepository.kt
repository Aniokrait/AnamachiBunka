package io.github.aniokrait.anamachibunka.logic.repository

import io.github.aniokrait.anamachibunka.logic.database.Heritage

interface HeritageRepository: FakeRemoteHeritageRepository, LocalHeritageRepository {
    override suspend fun getHeritages() : List<Heritage>
    override suspend fun getHeritageById(id: Int) : Heritage
    override suspend fun insert(heritage: Heritage)
    override suspend fun insertAll(vararg heritage: Heritage)
}