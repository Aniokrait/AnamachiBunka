package io.github.aniokrait.anamachibunka.logic.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heritages")
data class Heritage(
    @PrimaryKey var id: Int,
    var name: String,
    val latitude: Double,
    val longitude: Double
)