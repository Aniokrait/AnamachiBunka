package io.github.aniokrait.anamachibunka.logic.dataclass

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HeritageUiModel(
    val id: Int,
    val name: String,
    val longitude: Double,
    val latitude: Double
): Parcelable
