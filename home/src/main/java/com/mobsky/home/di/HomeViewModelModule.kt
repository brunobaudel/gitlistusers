package com.mobsky.home.di

import com.mobsky.home.presentation.home.HomeScreenViewModel
import com.mobsky.home.presentation.user_repositories.UserRepositoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val homeViewModelModules = module {
    viewModel {
        HomeScreenViewModel(getUsersUseCase = get())
    }

    viewModel {
        UserRepositoryViewModel(getUserRepositoriesUseCase = get(), savedStateHandle = get())
    }
}
