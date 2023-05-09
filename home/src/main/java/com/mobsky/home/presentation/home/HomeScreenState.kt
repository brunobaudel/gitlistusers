package com.mobsky.home.presentation.home

import com.mobsky.home.data.repository.Users

data class HomeScreenState(
    val isLoad : Boolean = true,
    var users: Users = mutableListOf()
)