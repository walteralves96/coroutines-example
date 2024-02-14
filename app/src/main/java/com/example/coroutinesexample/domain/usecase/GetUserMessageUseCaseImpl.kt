package com.example.coroutinesexample.domain.usecase

import kotlinx.coroutines.delay
import kotlin.random.Random

class GetUserMessageUseCaseImpl : GetUserMessageUseCase {
    override suspend operator fun invoke(): Result<String> = runCatching {
        if (Random.nextBoolean()) {
            delay(3000L)
            "Hello, Earth!"
        } else {
            "Hello Moon"
        }
    }
}
