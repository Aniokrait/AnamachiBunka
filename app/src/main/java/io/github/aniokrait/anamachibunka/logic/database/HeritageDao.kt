package io.github.aniokrait.anamachibunka.logic.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HeritageDao {
    @Query("SELECT * FROM heritages")
    fun getHeritages(): List<Heritage>

    @Query("SELECT * FROM heritages WHERE id = :id")
    fun getHeritageById(id: Int): Heritage

    @Insert
    fun insert(heritage: Heritage)

    @Insert
    fun insertAll(vararg heritage: Heritage)
}