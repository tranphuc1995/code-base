package com.phucth.mycodebase.data

import com.phucth.mycodebase.data.api.UsApi
import com.phucth.mycodebase.domain.mapper.PopulationUsModelApiToPopulationModelUi
import com.phucth.mycodebase.domain.mapper.mapToModelUi
import com.phucth.mycodebase.domain.repository.UsNationalRepository
import com.phucth.mycodebase.presentation.model_ui.ModelUiAfterRequestApi
import com.phucth.mycodebase.presentation.model_ui.PopulationModelUi
import com.phucth.service.RepositoryBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UsNationalRepositoryImpl(private val usApi: UsApi) : UsNationalRepository, RepositoryBase() {
    override suspend fun getPopulationUS(): Flow<ModelUiAfterRequestApi<PopulationModelUi>> {
        return safeApiCall {
            usApi.getPopulationFromUs(
                "Nation",
                "Population"
            )
        }.map { resultFromApi ->
            resultFromApi.mapToModelUi(
                resultFromApi,
                functionMap = PopulationUsModelApiToPopulationModelUi::map
            )
        }
    }
}