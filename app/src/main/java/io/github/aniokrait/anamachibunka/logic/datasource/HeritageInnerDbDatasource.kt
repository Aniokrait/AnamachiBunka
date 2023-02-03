package io.github.aniokrait.anamachibunka.logic.datasource

import io.github.aniokrait.anamachibunka.logic.hilt.data.Heritage
import io.github.aniokrait.anamachibunka.logic.hilt.data.HeritageDao
import io.github.aniokrait.anamachibunka.logic.repository.HeritageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HeritageInnerDbDatasource @Inject constructor(private val heritageDao: HeritageDao): HeritageRepository {
    override suspend fun getHeritages(): List<Heritage> = heritageDao.getHeritages()
    override suspend fun insert(heritage: Heritage) = heritageDao.insert(heritage)
}