package com.example.coroutinesexample.di

import com.example.coroutinesexample.domain.usecase.GetUserMessageUseCase
import com.example.coroutinesexample.domain.usecase.GetUserMessageUseCaseImpl
import com.example.coroutinesexample.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModel { MainViewModel(getUserMessageUseCase = get()) }
}

val domainModule = module {
    single<GetUserMessageUseCase> { GetUserMessageUseCaseImpl() }
}

