package com.mobsky.home.presentation.home

import com.mobsky.home.data.repository.Users

data class HomeScreenState(
    val taskState : TaskState = TaskState.NOT_STARTED,
    var users: Users = mutableListOf()
)

enum class TaskState {
    NOT_STARTED,
    IN_PROGRESS,
    COMPLETE
}