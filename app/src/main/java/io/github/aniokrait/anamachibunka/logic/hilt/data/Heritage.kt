package io.github.aniokrait.anamachibunka.logic.hilt.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heritages")
data class Heritage(
    @PrimaryKey var id: Int,
    var name: String,
)