package io.github.aniokrait.anamachibunka.logic.hilt.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HeritageDao {
    @Query("SELECT * FROM heritages")
    fun getHeritages(): List<Heritage>

    @Insert
    fun insert(heritage: Heritage)
}