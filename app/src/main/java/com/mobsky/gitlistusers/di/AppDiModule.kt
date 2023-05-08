package com.mobsky.gitlistusers.di

import com.mobsky.gitlistusers.BuildConfig
import com.mobsky.home.data.network.api.GitHubApi
import com.mobsky.home.di.homeModules
import com.mobsky.network.StartNetworkParameters
import com.mobsky.network.startNetwork
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import retrofit2.Retrofit

val startNetworkParameters = StartNetworkParameters(
    baseUrl = BuildConfig.BASE_URL,
    isDebug = BuildConfig.DEBUG
)

val appDiModule = module {

    single {
        get<Retrofit> {
            parametersOf(startNetworkParameters)
        }.create(GitHubApi::class.java)
    }

}

fun getAppModules(): List<Module> =
    listOf(
        startNetwork,
        appDiModule
    ).plus(homeModules)

