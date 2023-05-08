package com.mobsky.home.data.repository.mapper

import com.mobsky.home.data.network.api.model.user.UsersResponse
import com.mobsky.home.data.network.api.model.user_repository.UserRepositoryResponse
import com.mobsky.home.domain.model.GitRepository
import com.mobsky.home.domain.model.GitUser


fun UsersResponse?.toGitUsers(): GitUser =
    this?.let {
        GitUser(
            name = login
        )
    } ?: GitUser()

fun List<UsersResponse>?.toGitUsers(): List<GitUser> =
    this?.map { it.toGitUsers() } ?: listOf()

fun UserRepositoryResponse?.toGitRepository(): GitRepository =
    this?.let {
        GitRepository(
            name = name,
            isPrivate = isPrivate,
            createdAt = createdAt
        )
    } ?: GitRepository()

fun List<UserRepositoryResponse>?.toGitRepositories(): List<GitRepository> =
    this?.map { it.toGitRepository() } ?: listOf()