package com.mobsky.home.domain.model

data class GitRepository(
    val name: String = "",
    val description: String = "",
    val isPrivate: Boolean = false,
    val createdAt: String = "",
    val ownerName: String = "",
    val ownerAvatarUrl: String = "",
    val starCount: Int = 0,
    val forksCount: Int = 0
)