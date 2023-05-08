package com.mobsky.home.data.network

import com.google.gson.Gson
import com.mobsky.home.data.network.api.GitHubApi
import com.mobsky.home.data.network.api.model.user.UsersResponse
import com.mobsky.home.data.network.api.model.user_repository.UserRepositoryResponse
import com.mobsky.network.util.ResultWrapper
import com.mobsky.network.util.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class GitHubShowProjectsNetworkImpl(
    private val gitHubApi: GitHubApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : GitHubNetwork {

    override suspend fun getUsers(): ResultWrapper<List<UsersResponse>> =
        safeApiCall(
            dispatcher = dispatcher,
            apiCall = {
                gitHubApi.getUsers()
            },
            transformError = {
                ""
//                Gson().fromJson(it, GitHubErrorModel::class.java).message
            }
        )

    override suspend fun getUserInfo(userName: String): ResultWrapper<UsersResponse> =
        safeApiCall(
            dispatcher = dispatcher,
            apiCall = {
                gitHubApi.getUserInfo(userName)
            },
            transformError = {
                ""
//                Gson().fromJson(it, GitHubErrorModel::class.java).message
            }
        )

    override suspend fun getUserRepositories(userName: String): ResultWrapper<List<UserRepositoryResponse>> =
        safeApiCall(
            dispatcher = dispatcher,
            apiCall = {
                gitHubApi.getUserRepositories(userName)
            },
            transformError = {
                ""
//                Gson().fromJson(it, GitHubErrorModel::class.java).message
            }
        )
}
