package com.mobsky.home.data.repository

import com.mobsky.home.domain.model.GitRepository
import com.mobsky.home.domain.model.GitUser

typealias Users = List<GitUser>
typealias User = GitUser
typealias UserRepositories = List<GitRepository>

interface GitHubRepository {
    suspend fun getUsers(): Users
    suspend fun getUserInfo(userName: String): User
    suspend fun getUserRepositories(userName: String): UserRepositories
}