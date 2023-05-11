package com.mobsky.home.domain.usecase

import com.mobsky.home.data.repository.GitHubRepository
import com.mobsky.home.data.repository.User

class GetUserUseCase(
    private val gitHubRepository: GitHubRepository
) : UseCase<User, String?>() {

    override suspend fun run(params: String?): User = let {
        if(!params.isNullOrBlank()) {
            gitHubRepository.getUserInfo(params)
        }else{
            throw IllegalArgumentException("O nome do usuario não pode ser vazio!")
        }
    }
}