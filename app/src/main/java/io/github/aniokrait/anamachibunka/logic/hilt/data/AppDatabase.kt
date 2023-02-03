package io.github.aniokrait.anamachibunka.logic.hilt.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Heritage::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun heritageDao(): HeritageDao
}