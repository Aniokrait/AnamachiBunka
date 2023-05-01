package io.github.aniokrait.anamachibunka.logic.datasource

import io.github.aniokrait.anamachibunka.logic.database.Heritage
import io.github.aniokrait.anamachibunka.logic.repository.FakeRemoteHeritageRepository
import io.github.aniokrait.anamachibunka.logic.repository.HeritageRepository
import io.github.aniokrait.anamachibunka.logic.repository.LocalHeritageRepository
import javax.inject.Inject

class CombinedHeritageDataSource @Inject constructor(
    private val remoteRepository: FakeRemoteHeritageRepository,
    private val localRepository: LocalHeritageRepository
): HeritageRepository {

    override suspend fun getHeritages(): List<Heritage> {
        val cachedHeritages = localRepository.getHeritages()
        if(cachedHeritages.isNotEmpty()) {
            return cachedHeritages
        }
        val remoteHeritages = remoteRepository.getHeritages()
        localRepository.insertAll(*remoteHeritages.toTypedArray())
        return remoteHeritages
    }

    override suspend fun getHeritageById(id: Int): Heritage {
        return localRepository.getHeritageById(id)
    }

    override suspend fun insert(heritage: Heritage) {
        localRepository.insert(heritage)
    }

    override suspend fun insertAll(vararg heritage: Heritage) {
        localRepository.insertAll()
    }

}