package com.example.coroutinesexample.data.model

import com.example.coroutinesexample.domain.model.Breeds

class BreedsResponse(
    val message: Map<String, List<String>>,
    val status: String
) {
    fun toDomain() = Breeds(
        message = message,
        status = status
    )
}