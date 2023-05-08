package com.mobsky.home.data.repository

import com.mobsky.home.domain.model.GitRepository
import com.mobsky.home.domain.model.GitUser

typealias Users = List<GitUser>
typealias UserRepositories = List<GitRepository>

interface GitHubRepository {
    suspend fun getUsers(): Users
    suspend fun getUserInfo(userName: String): GitUser
    suspend fun getUserRepositories(userName: String): UserRepositories
}