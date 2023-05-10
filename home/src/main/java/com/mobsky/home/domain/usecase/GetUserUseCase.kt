package com.mobsky.home.domain.usecase

import com.mobsky.home.data.repository.GitHubRepository
import com.mobsky.home.data.repository.User

class GetUserUseCase(
    private val gitHubRepository: GitHubRepository
) : UseCase<User, String>() {

    override suspend fun run(params: String): User = gitHubRepository.getUserInfo(params)
}