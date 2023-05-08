package com.mobsky.home.domain.usecase

import com.mobsky.home.data.repository.GitHubRepository
import com.mobsky.home.data.repository.Users

class GetUsersUseCase(
    private val gitHubRepository: GitHubRepository
) : UseCase<Users, Void>() {

    override suspend fun run(params: Void): Users = gitHubRepository.getUsers()

}