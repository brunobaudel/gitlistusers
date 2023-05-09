package com.mobsky.home.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobsky.home.data.repository.Users
import com.mobsky.home.domain.usecase.GetUsersUseCase
import com.mobsky.home.domain.usecase.invoke
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenState())// MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()

    fun getUsers() {
        viewModelScope.launch {
            val listUsers = getUsersUseCase.invoke()
            updateScreenState(listUsers)
        }
    }

    private fun updateScreenState(users: Users) {
        _uiState.update { currentState ->
            currentState.copy(
                isLoad = false,
                users = users
            )
        }
    }


}