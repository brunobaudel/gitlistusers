package com.mobsky.home.domain.usecase

import com.mobsky.home.data.repository.GitHubRepository
import com.mobsky.home.data.repository.Users

class GetUserUseCase(private val gitHubRepository: GitHubRepository
) : UseCase<Users, Void>()  {


    override suspend fun run(params: Void): Users {
        TODO("Not yet implemented")
    }
}