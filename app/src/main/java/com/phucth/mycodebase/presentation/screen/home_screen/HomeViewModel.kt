package com.phucth.mycodebase.presentation.screen.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phucth.base.model.ErrorMessageApi
import com.phucth.base.model.StateScreen
import com.phucth.mycodebase.domain.usecases.GetListFilmUseCase
import com.phucth.mycodebase.presentation.model_ui.FilmModelUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val getListFilmUseCase: GetListFilmUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow<StateScreen<List<FilmModelUi>>>(StateScreen.Loading)
    val state: StateFlow<StateScreen<List<FilmModelUi>>> = _state.asStateFlow()

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            getListFilmUseCase.execute().collect { data ->
                if (data.errorMessageApi == null) {
                    _state.value = StateScreen.DataScreen(data = data.modelUi ?: arrayListOf())
                } else {
                    _state.value =
                        StateScreen.Error(messageApi = data.errorMessageApi ?: ErrorMessageApi())
                }
            }
        }
    }
}