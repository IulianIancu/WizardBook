package com.iulian.iancu.spells.domain

import com.iulian.iancu.common.Either

class GetSpellsUseCase(private val spellsRepository: SpellsRepository) {

    private suspend fun run(): Either<Throwable, List<Spell>> {
        return spellsRepository.getSpells()
    }

    suspend operator fun invoke(): Either<Throwable, List<Spell>> {
        return run()
    }
}