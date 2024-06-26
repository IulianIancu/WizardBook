package com.iulian.iancu.elixirs.domain

import com.iulian.iancu.common.Either

class GetElixirsUseCase(private val elixirsRepository: ElixirsRepository) {
    private suspend fun run(): Either<Throwable, List<Elixir>> {
        return elixirsRepository.getElixirs()
    }

    suspend operator fun invoke(): Either<Throwable, List<Elixir>> {
        return run()
    }
}