package io.github.aniokrait.anamachibunka.logic.datasource

import io.github.aniokrait.anamachibunka.logic.database.Heritage
import io.github.aniokrait.anamachibunka.logic.database.HeritageDao
import io.github.aniokrait.anamachibunka.logic.repository.HeritageRepository
import io.github.aniokrait.anamachibunka.logic.repository.LocalHeritageRepository
import javax.inject.Inject

class HeritageInnerDbDatasource @Inject constructor(private val heritageDao: HeritageDao): LocalHeritageRepository {
    override suspend fun getHeritages(): List<Heritage> = heritageDao.getHeritages()
    override suspend fun insert(heritage: Heritage) = heritageDao.insert(heritage)
    override suspend fun insertAll(vararg heritage: Heritage) = heritageDao.insertAll(*heritage)
}