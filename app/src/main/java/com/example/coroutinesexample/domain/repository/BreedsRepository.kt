package com.example.coroutinesexample.domain.repository

import com.example.coroutinesexample.domain.model.Breeds

interface BreedsRepository {
    suspend fun getBreeds(): Breeds
}