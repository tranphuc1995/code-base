package com.phucth.mycodebase.domain.mapper

import com.phucth.mycodebase.data.model_api.PopulationUsModelApi
import com.phucth.mycodebase.presentation.model_ui.PopulationModelUi

object PopulationUsModelApiToPopulationModelUi {
    fun map(populationUsModelApi: PopulationUsModelApi?): PopulationModelUi {
        return PopulationModelUi(
            population = populationUsModelApi?.data?.get(0)?.population ?: "",
            year = populationUsModelApi?.data?.get(0)?.year ?: ""
        )
    }
}