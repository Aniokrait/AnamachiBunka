package io.github.aniokrait.anamachibunka.logic.datasource

import io.github.aniokrait.anamachibunka.logic.database.Heritage
import io.github.aniokrait.anamachibunka.logic.repository.HeritageRepository
import javax.inject.Inject

class FakeHeritageDataSource @Inject constructor(): HeritageRepository {
    override suspend fun getHeritages(): List<Heritage> {
        val heritage1 = Heritage(id = 0, name = "旧丹羽家住宅蔵", longitude = 35.73797, latitude = 139.7425)
        val heritage2 = Heritage(id = 0, name = "雑司ケ谷鬼子母神堂", longitude = 35.7221, latitude = 139.7133)
        val heritages = mutableListOf<Heritage>().apply {
            add(heritage1)
            add(heritage2)
        }
        return heritages
    }

    override suspend fun insert(heritage: Heritage){
        TODO("not implemented")
    }
    override suspend fun insertAll(vararg heritage: Heritage){
        TODO("not implemented")
    }
}