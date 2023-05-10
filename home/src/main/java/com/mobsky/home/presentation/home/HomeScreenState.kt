package com.mobsky.home.presentation.home

import com.mobsky.home.data.repository.Users
import com.mobsky.home.presentation.util.ScreenState
import com.mobsky.home.presentation.util.TaskState

data class HomeScreenState(
    val taskState: TaskState = TaskState.NotStarted,
    var users: Users = mutableListOf()
): ScreenState(taskState)