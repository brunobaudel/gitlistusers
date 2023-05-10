package com.mobsky.home.data.repository.mapper

import com.mobsky.home.data.network.api.model.user.UserInfoResponse
import com.mobsky.home.data.network.api.model.user_repository.UserRepositoryResponse
import com.mobsky.home.domain.model.GitRepository
import com.mobsky.home.domain.model.GitUser


fun UserInfoResponse?.toGitUsers(): GitUser =
    this?.let {
        GitUser(
            id = id.toString(),
            name = login,
            avatarUrl = avatarUrl,
            url = url
        )
    } ?: GitUser()

fun List<UserInfoResponse>?.toGitUsers(): List<GitUser> =
    this?.map { it.toGitUsers() } ?: listOf()

fun UserRepositoryResponse?.toGitRepository(): GitRepository =
    this?.let {
        GitRepository(
            name = name.orEmpty(),
            description = description.orEmpty(),
            isPrivate = isPrivate,
            createdAt = createdAt.orEmpty(),
            ownerName = owner.login,
            ownerAvatarUrl = owner.avatarUrl,
            starCount = stargazersCount,
            forksCount = forksCount,

        )
    } ?: GitRepository()

fun List<UserRepositoryResponse>?.toGitRepositories(): List<GitRepository> =
    this?.map { it.toGitRepository() } ?: listOf()