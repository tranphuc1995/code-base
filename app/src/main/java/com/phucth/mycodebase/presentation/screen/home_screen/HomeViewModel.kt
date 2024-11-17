package com.phucth.mycodebase.presentation.screen.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phucth.mycodebase.domain.usecases.GetListFilmUseCase
import com.phucth.mycodebase.presentation.model_ui.FilmModelUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val getListFilmUseCase: GetListFilmUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow(arrayListOf<FilmModelUi>())
    val state: StateFlow<List<FilmModelUi>> = _state

    fun getData() {
        viewModelScope.launch {
            getListFilmUseCase.execute().collect { data ->
                if (data.errorMessageApi == null) {
                    _state.value = (data.modelUi ?: arrayListOf()) as ArrayList<FilmModelUi>
                } else {
                    println("failed")
                }
            }
        }
    }
}