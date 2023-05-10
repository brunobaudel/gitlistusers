package com.mobsky.home.presentation.user_profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobsky.home.data.repository.User
import com.mobsky.home.domain.usecase.GetUserUseCase
import com.mobsky.home.presentation.util.TaskState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserProfileViewModel(
    savedStateHandle: SavedStateHandle,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val userId: String = checkNotNull(savedStateHandle["username"])

    private val _uiState = MutableStateFlow(UserProfileScreenState())
    val uiState: StateFlow<UserProfileScreenState> = _uiState.asStateFlow()

    fun getUserInfo(userName: String? = null) {

        val userNameParams = if (userName.isNullOrBlank()) {
            userId
        } else {
            userName
        }

        try{
            viewModelScope.launch {
                val user = getUserUseCase.invoke(userNameParams)
                updateScreenStatSuccess(user)
            }
        }catch (e: Exception){
            updateScreenStateError(e)
        }
    }

    private fun updateScreenStatSuccess(user:User) {
        _uiState.update { currentState ->
            currentState.copy(
                user = user,
                taskState = TaskState.Complete
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