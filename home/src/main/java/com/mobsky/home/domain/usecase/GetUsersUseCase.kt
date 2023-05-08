package com.mobsky.home.domain.usecase

import com.mobsky.home.data.repository.GitHubRepository
import com.mobsky.home.data.repository.Users

class GetUsersUseCase(
    private val gitHubRepository: GitHubRepository
) : UseCase<Users, Unit>() {

    override suspend fun run(params: Unit): Users = gitHubRepository.getUsers()

}