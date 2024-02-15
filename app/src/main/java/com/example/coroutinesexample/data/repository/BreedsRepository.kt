package com.example.coroutinesexample.data.repository

import com.example.coroutinesexample.data.api.BreedsApi

class BreedsRepository(private val breedsApi: BreedsApi) {
    suspend fun getBreeds() = breedsApi.getBreeds()
}