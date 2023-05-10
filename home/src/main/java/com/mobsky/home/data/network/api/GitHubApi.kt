package com.mobsky.home.data.network.api

import com.mobsky.home.data.network.api.model.user.UserInfoResponse
import com.mobsky.home.data.network.api.model.user_repository.UserRepositoryResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    /**
     * Lista os usuários
     */
    @GET("users")
    suspend fun getUsers(): List<UserInfoResponse>

    /**
     * Obtem informações específicas de um usuário
     */
    @GET("users/{username}")
    suspend fun getUserInfo(@Path("username") userName: String): UserInfoResponse

    /**
     * Lista os repositórios de um usuário específico
     */
    @GET("users/{username}/repos")
    suspend fun getUserRepositories(@Path("username") userName: String): List<UserRepositoryResponse>

}