package com.mobsky.home.di

import com.mobsky.home.data.network.GitHubNetwork
import com.mobsky.home.data.network.GitHubNetworkImpl
import com.mobsky.home.data.repository.GitHubRepository
import com.mobsky.home.data.repository.GitHubRepositoryImpl
import org.koin.dsl.module

private val homeNetworkModules = module {
    single<GitHubNetwork> { GitHubNetworkImpl(get()) }
}

private val homeRepositoryModule = module {
    single<GitHubRepository> { GitHubRepositoryImpl(get()) }
}

val homeModules = listOf(
    homeNetworkModules,
    homeRepositoryModule,
    homeUseCasesModules,
    homeViewModelModules
)