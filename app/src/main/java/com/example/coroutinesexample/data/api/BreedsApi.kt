package com.example.coroutinesexample.data.api

import com.example.coroutinesexample.data.model.BreedsResponse
import retrofit2.http.GET

interface BreedsApi {

    @GET("breeds/list/all")
    suspend fun getBreeds(): BreedsResponse

}