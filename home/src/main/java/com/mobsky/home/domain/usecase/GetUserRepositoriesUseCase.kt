package com.mobsky.home.domain.usecase

import com.mobsky.home.data.repository.GitHubRepository
import com.mobsky.home.data.repository.UserRepositories
import com.mobsky.home.data.repository.Users

class GetUserRepositoriesUseCase(
    private val gitHubRepository: GitHubRepository
) : UseCase<UserRepositories, String>() {
    override suspend fun run(params: String): UserRepositories = let {

        val result = try {
            gitHubRepository.getUserRepositories(params)
        }catch (e: Exception){
            e.message
            mutableListOf()
        }

        result
    }
}