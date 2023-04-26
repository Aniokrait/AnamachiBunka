package io.github.aniokrait.anamachibunka.logic.hilt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.aniokrait.anamachibunka.logic.database.HeritageDao
import io.github.aniokrait.anamachibunka.logic.datasource.CombinedHeritageDataSource
import io.github.aniokrait.anamachibunka.logic.datasource.FakeHeritageDataSource
import io.github.aniokrait.anamachibunka.logic.datasource.HeritageInnerDbDatasource
import io.github.aniokrait.anamachibunka.logic.repository.HeritageRepository

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun provideRemoteDataSource(): FakeHeritageDataSource {
        return FakeHeritageDataSource()
    }

    @Provides
    fun provideLocalDataSource(heritageDao: HeritageDao): HeritageInnerDbDatasource {
        return HeritageInnerDbDatasource(heritageDao = heritageDao)
    }

    @Provides
    fun provideHeritageRepository(localDatasource: HeritageInnerDbDatasource,
                                  fakeRemoteDatasource: FakeHeritageDataSource
    ): HeritageRepository {
        return CombinedHeritageDataSource(fakeRemoteDatasource, localDatasource)
    }

}