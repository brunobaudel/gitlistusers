package com.mobsky.home.di

import com.mobsky.home.presentation.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val homeViewModelModules = module {
    viewModel {
        HomeScreenViewModel(getUsersUseCase = get())
    }
}
