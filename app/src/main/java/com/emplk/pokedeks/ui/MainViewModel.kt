package com.emplk.pokedeks.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.emplk.pokedeks.domain.GetRandomPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.switchMap
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRandomPokemonUseCase: GetRandomPokemonUseCase,
) : ViewModel() {

    private val randomStringIdMutableStateFlow = MutableStateFlow((1..898).random().toString())

    val viewStateLiveData: LiveData<PokemonViewState> =
        randomStringIdMutableStateFlow.flatMapLatest { randomStringId ->
            getRandomPokemonUseCase.invoke(randomStringId)
        }.map { pokemonEntity ->
            PokemonViewState(
                id = pokemonEntity.id,
                name = pokemonEntity.name,
                imageUrl = pokemonEntity.imageUrl,
            )
        }.asLiveData()

    fun onRandomizeButtonClicked() {
        randomStringIdMutableStateFlow.value = (1..898).random().toString()
    }
}