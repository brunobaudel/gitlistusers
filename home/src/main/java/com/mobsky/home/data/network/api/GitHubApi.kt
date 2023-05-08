package com.mobsky.home.data.network.api

import com.mobsky.home.data.network.api.model.user.UsersResponse
import com.mobsky.home.data.network.api.model.user_repository.UserRepositoryResponse
import retrofit2.http.GET

interface GitHubApi {

    /**
     * Lista os usuários
     */
    @GET("users")
    suspend fun getUsers(): List<UsersResponse>

    /**
     * Obtem informações específicas de um usuário
     */
    @GET("users/{username}")
    suspend fun getUserInfo(userName: String): UsersResponse

    /**
     * Lista os repositórios de um usuário específico
     */
    @GET("users/{username}/repos")
    suspend fun getUserRepositories(userName: String): List<UserRepositoryResponse>

}