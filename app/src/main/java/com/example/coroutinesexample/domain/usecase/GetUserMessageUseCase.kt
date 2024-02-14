package com.example.coroutinesexample.domain.usecase

interface GetUserMessageUseCase {
    suspend operator fun invoke(): Result<String>
}