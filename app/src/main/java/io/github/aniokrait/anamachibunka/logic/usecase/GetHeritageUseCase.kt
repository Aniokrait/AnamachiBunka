package io.github.aniokrait.anamachibunka.logic.usecase

import io.github.aniokrait.anamachibunka.logic.dataclass.HeritageUiModel
import io.github.aniokrait.anamachibunka.logic.repository.HeritageRepository
import javax.inject.Inject

class GetHeritageUseCase @Inject constructor(private val heritageRepository: HeritageRepository) {
    suspend operator fun invoke(id: Int): HeritageUiModel {
        val heritageRecord = heritageRepository.getHeritageById(id)
        val heritage: HeritageUiModel = heritageRecord.let {
            HeritageUiModel(id = it.id, name = it.name, longitude = it.longitude, latitude = it.latitude)
        }
        return heritage
    }
}