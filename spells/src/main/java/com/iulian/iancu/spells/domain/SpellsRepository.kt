package com.iulian.iancu.spells.domain

import com.iulian.iancu.common.Either

interface SpellsRepository {

    suspend fun getSpells(): Either<Throwable, List<Spell>>
}