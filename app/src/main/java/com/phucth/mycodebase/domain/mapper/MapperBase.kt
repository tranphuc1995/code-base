package com.phucth.mycodebase.domain.mapper

import com.phucth.mycodebase.presentation.model_ui.ModelUiAfterRequestApi
import com.phucth.service.model.ResultNetworkApi

fun <T, X> ResultNetworkApi<T>.mapToModelUi(
    responseFromApi: ResultNetworkApi<T>,
    functionMap: (T?) -> X
): ModelUiAfterRequestApi<X> {
    if (responseFromApi.error != null) {
        return ModelUiAfterRequestApi(modelUi = null, errorMessageApi = responseFromApi.error)
    } else {
        val modelUi = functionMap(responseFromApi.modelResponseFromApi)
        return ModelUiAfterRequestApi(modelUi = modelUi, errorMessageApi = null)
    }
}