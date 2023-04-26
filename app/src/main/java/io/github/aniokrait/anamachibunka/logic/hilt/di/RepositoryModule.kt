package io.github.aniokrait.anamachibunka.logic.hilt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.aniokrait.anamachibunka.logic.database.HeritageDao
import io.github.aniokrait.anamachibunka.logic.datasource.FakeHeritageDataSource
import io.github.aniokrait.anamachibunka.logic.datasource.HeritageInnerDbDatasource
import io.github.aniokrait.anamachibunka.logic.repository.CombinedRepository

@InstallIn(SingletonComponent::class)
@Module
//abstract class RepositoryModule {
object RepositoryModule {

//    @Binds
//    abstract fun bindHeritageRepository(impl: HeritageInnerDbDatasource): HeritageRepository

//    @Provides
//    fun provideHeritageRepository(impl: FakeHeritageDataSource): HeritageRepository {
//        return FakeHeritageDataSource()
//    }

    @Provides
    fun provideRemoteDataSource(): FakeHeritageDataSource {
        return FakeHeritageDataSource()
    }

    @Provides
    fun provideLocalDbDataSource(heritageDao: HeritageDao): HeritageInnerDbDatasource {
        return HeritageInnerDbDatasource(heritageDao = heritageDao)
    }

    @Provides
    fun provideCombinedHeritageRepository(
        localDatasource: HeritageInnerDbDatasource,
        fakeRemoteDatasource: FakeHeritageDataSource
    ): CombinedRepository {
        return CombinedRepository(localDatasource, fakeRemoteDatasource)
    }

}