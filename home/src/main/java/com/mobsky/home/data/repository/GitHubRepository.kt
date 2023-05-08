package com.mobsky.home.data.repository

import com.mobsky.home.domain.model.GitRepository
import com.mobsky.home.domain.model.GitUser

interface GitHubRepository {
    suspend fun getUsers(): List<GitUser>
    suspend fun getUserInfo(userName: String): GitUser
    suspend fun getUserRepositories(userName: String): List<GitRepository>
}