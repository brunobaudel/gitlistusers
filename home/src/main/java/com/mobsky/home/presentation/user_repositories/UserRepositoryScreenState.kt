package com.mobsky.home.presentation.user_repositories

import com.mobsky.home.data.repository.UserRepositories
import com.mobsky.home.presentation.util.ScreenState
import com.mobsky.home.presentation.util.TaskState

data class UserRepositoryScreenState(
    val taskState: TaskState = TaskState.NotStarted,
    var userRepositories: UserRepositories = mutableListOf()
) : ScreenState(taskState)