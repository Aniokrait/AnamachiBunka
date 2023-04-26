package io.github.aniokrait.anamachibunka.logic.repository

import io.github.aniokrait.anamachibunka.logic.database.Heritage

interface FakeRemoteHeritageRepository {
    suspend fun getHeritages() : List<Heritage>
}