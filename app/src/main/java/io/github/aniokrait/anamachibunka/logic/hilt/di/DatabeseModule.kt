package io.github.aniokrait.anamachibunka.logic.hilt.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.aniokrait.anamachibunka.logic.database.AppDatabase
import io.github.aniokrait.anamachibunka.logic.database.HeritageDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideLogDao(database: AppDatabase): HeritageDao {
        return database.heritageDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "anamachi.db"
        ).build()
    }


}