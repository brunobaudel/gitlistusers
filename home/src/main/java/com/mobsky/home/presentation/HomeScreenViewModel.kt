package com.mobsky.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobsky.home.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {


    fun getUsers(){
        viewModelScope.launch {

        }
    }

}