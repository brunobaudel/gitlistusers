package com.mobsky.home.presentation

import com.mobsky.home.data.repository.Users

data class HomeScreenState(
    val isLoad : Boolean = true,
    var users: Users = mutableListOf()
)