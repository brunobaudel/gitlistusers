package com.mobsky.home.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mobsky.home.data.repository.User
import com.mobsky.home.data.repository.Users
import com.mobsky.home.domain.usecase.GetUsersUseCase
import com.mobsky.home.domain.usecase.invoke
import com.mobsky.home.presentation.util.TaskState
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


class HomeScreenViewModelTest {


    @get:Rule
    val rule = InstantTaskExecutorRule()


    private lateinit var viewModel: HomeScreenViewModel

    @Mock
    private val getUsersUseCase = mock<GetUsersUseCase>()

    @Before
    fun setUp() {

        viewModel = HomeScreenViewModel(getUsersUseCase)
    }

    @After
    fun cleanUp(){
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when view model getUsers get success then sets uiState TaskState to Complete`()= runTest {

        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)

        try {
            val users = listOf(User("John"))
            whenever(getUsersUseCase.invoke()).thenReturn(users)


            viewModel.getUsers()


            assertEquals(TaskState.Complete, viewModel.uiState.value.taskState)

        } finally {
            Dispatchers.resetMain()
        }

    }
}