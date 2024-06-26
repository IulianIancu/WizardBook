package com.iulian.iancu.elixirs.domain

import com.iulian.iancu.common.Either

interface ElixirsRepository {

    suspend fun getElixirs(): Either<Throwable, List<Elixir>>
}