package com.mobsky.home.presentation.user_search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobsky.home.data.repository.User
import com.mobsky.home.domain.usecase.GetUserUseCase
import com.mobsky.home.presentation.screen_sections.components.SearchableTopBarState
import com.mobsky.home.presentation.util.TaskState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserSearchViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UserSearchScreenState())
    val uiState: StateFlow<UserSearchScreenState> = _uiState.asStateFlow()

    val userName = mutableStateOf("")

    private val _searchableTopBarState = mutableStateOf<SearchableTopBarState>(SearchableTopBarState.Close)
    val searchableTopBarState: SearchableTopBarState
        get() = _searchableTopBarState.value

    fun setSearchableTopBarState(state: SearchableTopBarState) {
        _searchableTopBarState.value = state
    }

    fun getUserInfo() {
        viewModelScope.launch {
            try {
                updateScreenStateProgress()
                _searchableTopBarState.value = SearchableTopBarState.Open(userName.value)
                val user = getUserUseCase.invoke(userName.value)
                updateScreenStatSuccess(user)
            } catch (e: Exception) {
                updateScreenStateError(e)
            }
        }
    }

    private fun updateScreenStatSuccess(user: User) {
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

    private fun updateScreenStateProgress() {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.InProgress
            )
        }
    }

}