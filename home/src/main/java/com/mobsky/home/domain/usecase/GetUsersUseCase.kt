package com.mobsky.home.domain.usecase

import com.mobsky.home.data.repository.GitHubRepository
import com.mobsky.home.data.repository.Users
import com.mobsky.home.domain.model.GitUser

class GetUsersUseCase(
    private val gitHubRepository: GitHubRepository
) : UseCase<Users, Unit>() {

    override suspend fun run(params: Unit): Users = gitHubRepository.getUsers()

    private fun mock() =  listOf(
        GitUser(name = "mojombo", avatarUrl = "https://avatars.githubusercontent.com/u/20?v=4"),
        GitUser(name = "defunkt", avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
        GitUser(name = "technoweenie", avatarUrl = "https://avatars.githubusercontent.com/u/45?v=4"),
    )
}