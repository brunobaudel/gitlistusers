package com.mobsky.home.di


import com.mobsky.home.domain.usecase.GetUserUseCase
import com.mobsky.home.domain.usecase.GetUsersUseCase
import org.koin.dsl.module

internal val homeUseCasesModules = module {

    single {
        GetUsersUseCase(gitHubRepository = get())
    }

    single {
        GetUserUseCase(gitHubRepository = get())
    }

    single {
        GetUsersUseCase(gitHubRepository = get())
    }

}
