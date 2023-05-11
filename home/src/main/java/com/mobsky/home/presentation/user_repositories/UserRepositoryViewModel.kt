package com.mobsky.home.presentation.user_repositories

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobsky.home.data.repository.UserRepositories
import com.mobsky.home.domain.usecase.GetUserRepositoriesUseCase
import com.mobsky.home.presentation.util.TaskState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserRepositoryViewModel(
    savedStateHandle: SavedStateHandle,
    private val getUserRepositoriesUseCase: GetUserRepositoriesUseCase
) : ViewModel() {

    private val userId: String = checkNotNull(savedStateHandle["userName"])

    private val _uiState = MutableStateFlow(UserRepositoryScreenState())
    val uiState: StateFlow<UserRepositoryScreenState> = _uiState.asStateFlow()

    fun getUserRepositories(userName: String? = null) {

        val userNameParams = if (userName.isNullOrBlank()) {
            userId
        } else {
            userName
        }

        viewModelScope.launch {
            try {
                updateScreenStateProgress()
                val listUsers = getUserRepositoriesUseCase.invoke(userNameParams)
                successScreenState(listUsers)
            } catch (e: Exception) {
                updateScreenStateError(e)
            }
        }
    }

    private fun successScreenState(userRepositories: UserRepositories) {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.Complete,
                userRepositories = userRepositories
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

    private fun updateScreenStateError(exception: Exception) {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.Error(exception)
            )
        }
    }

}