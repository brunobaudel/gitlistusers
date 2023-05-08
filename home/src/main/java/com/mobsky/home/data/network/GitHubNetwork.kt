package com.mobsky.home.data.network

import com.mobsky.home.data.network.api.model.user.UsersResponse
import com.mobsky.home.data.network.api.model.user_repository.UserRepositoryResponse
import com.mobsky.network.util.ResultWrapper

interface GitHubNetwork {
    suspend fun getUsers(): ResultWrapper<List<UsersResponse>>
    suspend fun getUserInfo(userName: String): ResultWrapper<UsersResponse>
    suspend fun getUserRepositories(userName: String): ResultWrapper<List<UserRepositoryResponse>>
}