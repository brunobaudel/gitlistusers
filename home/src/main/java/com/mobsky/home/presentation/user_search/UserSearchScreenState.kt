package com.mobsky.home.presentation.user_search

import com.mobsky.home.data.repository.User
import com.mobsky.home.presentation.util.ScreenState
import com.mobsky.home.presentation.util.TaskState

data class UserSearchScreenState(
    val user: User = User(),
    val taskState : TaskState = TaskState.NotStarted
): ScreenState(taskState)