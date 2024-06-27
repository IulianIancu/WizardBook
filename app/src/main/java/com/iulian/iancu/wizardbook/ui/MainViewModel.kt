package com.iulian.iancu.wizardbook.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iulian.iancu.common.Either
import com.iulian.iancu.elixirs.domain.Elixir
import com.iulian.iancu.elixirs.domain.GetElixirsUseCase
import com.iulian.iancu.spells.domain.GetSpellsUseCase
import com.iulian.iancu.spells.domain.Spell
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel(
    private val getSpellsUseCase: GetSpellsUseCase,
    private val getElixirsUseCase: GetElixirsUseCase
) : ViewModel() {

    private val _elixirsList = MutableStateFlow<List<Elixir>>(emptyList())
    val elixirsList: StateFlow<List<Elixir>> = _elixirsList.asStateFlow()

    private val _spellsList = MutableStateFlow<List<Spell>>(emptyList())
    val spellsList: StateFlow<List<Spell>> = _spellsList.asStateFlow()


    init {
        viewModelScope.launch {
            val elixirs = getElixirsUseCase()
            val spells = getSpellsUseCase()

            if (elixirs is Either.Success){
                _elixirsList.value = elixirs.value
            }else{
                //TODO Bad UX, show error to user
                Log.e(elixirs.toString(),elixirs.toString())
            }

            if (spells is Either.Success){
                _spellsList.value = spells.value
            }else{
                //TODO Bad UX, show error to user
                Log.e(elixirs.toString(),elixirs.toString())
            }
        }
    }

}