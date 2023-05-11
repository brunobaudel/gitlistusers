package com.mobsky.home.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobsky.home.data.repository.Users
import com.mobsky.home.domain.usecase.GetUsersUseCase
import com.mobsky.home.domain.usecase.invoke
import com.mobsky.home.presentation.util.TaskState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()

    fun getUsers() {
        viewModelScope.launch {
            try {
                updateScreenStateProgress()
                delay(2000)
                val listUsers = getUsersUseCase.invoke()
                updateScreenStateSuccess(listUsers)
//                updateScreenStateError(java.lang.Exception())
            }catch (e: Exception){
                updateScreenStateError(e)
            }
        }
    }

    private fun updateScreenStateSuccess(users: Users) {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.Complete,
                users = users
            )
        }
    }

    private fun updateScreenStateError(exception: Exception) {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.Error(exception)
            )
        }
    }

    private fun updateScreenStateProgress() {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.InProgress
            )
        }
    }

}