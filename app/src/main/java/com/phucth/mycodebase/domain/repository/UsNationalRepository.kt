package com.phucth.mycodebase.domain.repository

import com.phucth.mycodebase.presentation.model_ui.ModelUiAfterRequestApi
import com.phucth.mycodebase.presentation.model_ui.PopulationModelUi
import kotlinx.coroutines.flow.Flow

interface UsNationalRepository {
    suspend fun getPopulationUS(): Flow<ModelUiAfterRequestApi<PopulationModelUi>>
}