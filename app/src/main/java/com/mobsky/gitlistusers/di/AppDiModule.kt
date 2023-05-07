package com.mobsky.gitlistusers.di

import com.mobsky.network.StartNetworkParameters
import com.mobsky.network.startNetwork
import org.koin.core.module.Module
import org.koin.dsl.module


val startNetworkParameters = StartNetworkParameters(
    baseUrl = "https://api.github.com ",
    isDebug = true
)

val appDiModule = module {

}

fun getAppModules(): List<Module> =
    listOf(
        startNetwork,
        appDiModule
    )

