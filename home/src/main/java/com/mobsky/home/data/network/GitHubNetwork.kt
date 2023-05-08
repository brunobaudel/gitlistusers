package com.mobsky.home.data.network

import com.mobsky.home.data.network.api.model.user.UsersResponse
import com.mobsky.home.data.network.api.model.user_repository.UserRepositoryResponse

interface GitHubNetwork {
    suspend fun getUsers(): List<UsersResponse>
    suspend fun getUserInfo(userName: String): UsersResponse
    suspend fun getUserRepositories(userName: String): List<UserRepositoryResponse>
}