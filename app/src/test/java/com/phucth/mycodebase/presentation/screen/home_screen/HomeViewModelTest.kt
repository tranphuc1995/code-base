package com.phucth.mycodebase.presentation.screen.home_screen

import com.phucth.base.model.ErrorMessageApi
import com.phucth.base.model.ResultModelUi
import com.phucth.base.model.StateScreen
import com.phucth.mycodebase.BaseViewModelTest
import com.phucth.mycodebase.domain.usecases.GetListFilmUseCase
import com.phucth.mycodebase.presentation.model_ui.FilmModelUi
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class HomeViewModelTest : BaseViewModelTest() {

    private lateinit var homeViewModel: HomeViewModel

    @MockK
    lateinit var getListFilmUseCase: GetListFilmUseCase


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        homeViewModel = HomeViewModel(getListFilmUseCase = getListFilmUseCase)
    }

    @Test
    fun test_case_api_return_success() = runTest {
        val expectedReturnData = arrayListOf(FilmModelUi())

        coEvery {
            getListFilmUseCase.execute()
        } returns flowOf(
            ResultModelUi(
                modelUi = expectedReturnData,
                errorMessageApi = null
            )
        )

        homeViewModel.getData()

        coVerify {
            getListFilmUseCase.execute()
        }
        assert(homeViewModel.state.value == StateScreen.DataScreen(data = expectedReturnData))
    }

    @Test
    fun test_case_api_return_failed() = runTest {
        val expectedReturnData = ErrorMessageApi()

        coEvery {
            getListFilmUseCase.execute()
        } returns flowOf(
            ResultModelUi(
                modelUi = null,
                errorMessageApi = expectedReturnData
            )
        )

        homeViewModel.getData()

        coVerify {
            getListFilmUseCase.execute()
        }
        assert(homeViewModel.state.value == StateScreen.Error(messageApi = expectedReturnData))
    }
}