package com.mobsky.home.presentation.util

sealed class TaskState{
   object NotStarted : TaskState()
   object InProgress : TaskState()
   object Complete : TaskState()
   class Error(val exception: Exception) : TaskState()
}
