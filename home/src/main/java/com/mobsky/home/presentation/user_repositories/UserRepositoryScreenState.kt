package com.mobsky.home.presentation.user_repositories

import com.mobsky.home.data.repository.UserRepositories

data class

UserRepositoryScreenState(
    val isLoad : Boolean = true,
    var userRepositories: UserRepositories = mutableListOf()
)