package com.mobsky.home.data.repository


import com.mobsky.home.data.network.GitHubNetwork
import com.mobsky.home.data.repository.mapper.toGitRepositories
import com.mobsky.home.data.repository.mapper.toGitUsers
import com.mobsky.home.domain.model.GitRepository
import com.mobsky.home.domain.model.GitUser
import com.mobsky.network.util.getSuccessResultWrapper
import com.mobsky.network.util.result

class GitHubRepositoryImpl(
    private val gitHubNetwork: GitHubNetwork
) : GitHubRepository {

    override suspend fun getUsers(): Users {
        return result {
                gitHubNetwork
                    .getUsers()
                    .getSuccessResultWrapper()
                    .toGitUsers()
        }
    }

    override suspend fun getUserInfo(userName: String): User {
        return result {
            gitHubNetwork
                .getUserInfo(userName)
                .getSuccessResultWrapper()
                .toGitUsers()
        }
    }

    override suspend fun getUserRepositories(userName: String): UserRepositories {
        return result {
            gitHubNetwork
                .getUserRepositories(userName)
                .getSuccessResultWrapper()
                .toGitRepositories()
        }
    }
}