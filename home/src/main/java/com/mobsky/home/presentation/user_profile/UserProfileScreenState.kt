package com.mobsky.home.presentation.user_profile

import com.mobsky.home.data.repository.User
import com.mobsky.home.presentation.util.ScreenState
import com.mobsky.home.presentation.util.TaskState

data class UserProfileScreenState(
    val user: User = User(),
    val taskState : TaskState = TaskState.NotStarted
): ScreenState(taskState)