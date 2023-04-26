package io.github.aniokrait.anamachibunka.logic.usecase

import io.github.aniokrait.anamachibunka.logic.dataclass.HeritageUiModel
import io.github.aniokrait.anamachibunka.logic.repository.CombinedRepository
import io.github.aniokrait.anamachibunka.logic.repository.HeritageRepository
import javax.inject.Inject

class GetNearHeritagesUseCase @Inject constructor(private val heritageRepository: CombinedRepository) {
    suspend operator fun invoke(): List<HeritageUiModel> {
        val heritageRecords = heritageRepository.getHeritages()
        val heritages: List<HeritageUiModel> = heritageRecords.map {
            HeritageUiModel(id = it.id, name = it.name, longitude = it.longitude, latitude = it.latitude)
        }
        return heritages
    }
}