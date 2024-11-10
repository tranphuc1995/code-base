package com.phucth.mycodebase.presentation.model_ui

import com.phucth.service.model.ErrorMessageApi

data class ModelUiAfterRequestApi<T>(val modelUi: T?, val errorMessageApi: ErrorMessageApi?)