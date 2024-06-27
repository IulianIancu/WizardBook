package com.iulian.iancu.wizardbook.di

import com.iulian.iancu.elixirs.data.ElixirsRepositoryImpl
import com.iulian.iancu.elixirs.data.ElixirsService
import com.iulian.iancu.elixirs.domain.ElixirsRepository
import com.iulian.iancu.elixirs.domain.GetElixirsUseCase
import com.iulian.iancu.spells.data.SpellsRepositoryImpl
import com.iulian.iancu.spells.data.SpellsService
import com.iulian.iancu.spells.domain.GetSpellsUseCase
import com.iulian.iancu.spells.domain.SpellsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MainModule {

    @Provides
    fun provideGetSpellsUseCase(spellsRepository: SpellsRepository): GetSpellsUseCase =
        GetSpellsUseCase(spellsRepository)

    @Provides
    fun provideGetElixirsUseCase(elixirsRepository: ElixirsRepository): GetElixirsUseCase =
        GetElixirsUseCase(elixirsRepository)

    @Provides
    fun provideSpellsRepository(spellsService: SpellsService): SpellsRepository =
        SpellsRepositoryImpl(spellsService)

    @Provides
    fun provideElixirRepository(elixirsService: ElixirsService): ElixirsRepository =
        ElixirsRepositoryImpl(elixirsService)

    @Provides
    fun provideSpellService(): SpellsService = SpellsService.getInstance()

    @Provides
    fun provideElixirService(): ElixirsService = ElixirsService.getInstance()
}