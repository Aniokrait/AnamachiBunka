package io.github.aniokrait.anamachibunka.logic.hilt.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.aniokrait.anamachibunka.logic.datasource.HeritageInnerDbDatasource
import io.github.aniokrait.anamachibunka.logic.repository.HeritageRepository

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindHeritageRepository(impl: HeritageInnerDbDatasource): HeritageRepository

}