package io.github.aniokrait.anamachibunka.logic.repository

import io.github.aniokrait.anamachibunka.logic.database.Heritage
import io.github.aniokrait.anamachibunka.logic.datasource.FakeHeritageDataSource
import io.github.aniokrait.anamachibunka.logic.datasource.HeritageInnerDbDatasource

class CombinedRepository(
    private val localDatasource: HeritageInnerDbDatasource,
    private val remoteDatasource: FakeHeritageDataSource
): HeritageRepository {
    override suspend fun getHeritages(): List<Heritage> {
        val cachedHeritages = localDatasource.getHeritages()
        if(cachedHeritages.isNotEmpty()) {
            return cachedHeritages
        }
        val remoteHeritages = remoteDatasource.getHeritages()
        localDatasource.insertAll(*remoteHeritages.toTypedArray())
        return remoteHeritages
    }

    override suspend fun insert(heritage: Heritage) {
        TODO("Not yet implemented")
    }

    override suspend fun insertAll(vararg heritage: Heritage) {
        TODO("Not yet implemented")
    }
}