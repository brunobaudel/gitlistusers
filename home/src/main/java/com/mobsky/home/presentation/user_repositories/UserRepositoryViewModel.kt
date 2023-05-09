package com.mobsky.home.presentation.user_repositories

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobsky.home.data.repository.UserRepositories
import com.mobsky.home.data.repository.Users
import com.mobsky.home.domain.usecase.GetUserRepositoriesUseCase
import com.mobsky.home.domain.usecase.GetUsersUseCase
import com.mobsky.home.domain.usecase.invoke
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserRepositoryViewModel(
    savedStateHandle: SavedStateHandle,
    private val getUserRepositoriesUseCase: GetUserRepositoriesUseCase
) : ViewModel() {

    private val userId: String = checkNotNull(savedStateHandle["username"])

    private val _uiState = MutableStateFlow(UserRepositoryScreenState())
    val uiState: StateFlow<UserRepositoryScreenState> = _uiState.asStateFlow()

    fun getUserRepositories(userName: String? = null) {

        val userNameParams = if(userName.isNullOrBlank()){
            userId
        }else{
            userName
        }

        viewModelScope.launch {
            val listUsers = getUserRepositoriesUseCase.invoke(userNameParams)
            updateScreenState(listUsers)
        }
    }

    private fun updateScreenState(userRepositories: UserRepositories) {
        _uiState.update { currentState ->
            currentState.copy(
                isLoad = false,
                userRepositories = userRepositories
            )
        }
    }


}