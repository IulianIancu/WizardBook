package com.iulian.iancu.spells.data

import com.iulian.iancu.common.Either
import com.iulian.iancu.spells.domain.Spell
import com.iulian.iancu.spells.domain.SpellsRepository

class SpellsRepositoryImpl(
    private val spellsService: SpellsService
) : SpellsRepository {
    override suspend fun getSpells(): Either<Throwable, List<Spell>> {
        val result = spellsService.getSpells()
        val body = result.body()
        return if (result.isSuccessful && !body.isNullOrEmpty()) {
            Either.success(body)
        } else {
            Either.fail(UnknownError())
        }
    }
}