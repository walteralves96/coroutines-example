package com.example.coroutinesexample.data.repository

import com.example.coroutinesexample.data.api.BreedsApi
import com.example.coroutinesexample.domain.repository.BreedsRepository

class BreedsRepositoryImpl(private val breedsApi: BreedsApi): BreedsRepository {
    override suspend fun getBreeds() = breedsApi.getBreeds().toDomain()

}