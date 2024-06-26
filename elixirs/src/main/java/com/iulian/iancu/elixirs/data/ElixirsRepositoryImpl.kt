package com.iulian.iancu.elixirs.data

import com.iulian.iancu.common.Either
import com.iulian.iancu.elixirs.domain.Elixir
import com.iulian.iancu.elixirs.domain.ElixirsRepository

class ElixirsRepositoryImpl(
    private val elixirsService: ElixirsService
) : ElixirsRepository {
    override suspend fun getElixirs(): Either<Throwable, List<Elixir>> {
        val result = elixirsService.getElixirs()
        val body = result.body()
        return if (result.isSuccessful && !body.isNullOrEmpty()) {
            Either.success(body)
        } else {
            Either.fail(UnknownError())
        }
    }
}


