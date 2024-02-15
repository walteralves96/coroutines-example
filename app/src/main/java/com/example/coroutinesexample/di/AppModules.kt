package com.example.coroutinesexample.di

import com.example.coroutinesexample.data.api.BreedsApi
import com.example.coroutinesexample.data.repository.BreedsRepository
import com.example.coroutinesexample.domain.usecase.GetUserMessageUseCase
import com.example.coroutinesexample.domain.usecase.GetUserMessageUseCaseImpl
import com.example.coroutinesexample.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val presentationModule = module {
    viewModel {
        MainViewModel(
            getUserMessageUseCase = get(),
            breedsRepository = get()
        )
    }
}

val dataModule = module {
    single { BreedsRepository(breedsApi = get()) }
}

val domainModule = module {
    single<GetUserMessageUseCase> { GetUserMessageUseCaseImpl() }
}

val networkModule = module {
    single {
        Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    }

    single<BreedsApi> { get<Retrofit>().create(BreedsApi::class.java) }

}

