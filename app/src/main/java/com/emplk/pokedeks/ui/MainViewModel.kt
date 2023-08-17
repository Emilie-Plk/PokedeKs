package com.emplk.pokedeks.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.emplk.pokedeks.domain.GetRandomPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRandomPokemonUseCase: GetRandomPokemonUseCase,
) : ViewModel() {

    private val randomStringIdMutableLiveData = MutableLiveData<String>().apply {
        value = (1..898).random().toString()
    }

    val viewStateLiveData: LiveData<PokemonViewState> = randomStringIdMutableLiveData.switchMap { randomStringId ->
        liveData {
            getRandomPokemonUseCase.invoke(randomStringId).collect { pokemonEntity ->
                emit(
                    PokemonViewState(
                        id = pokemonEntity.id,
                        name = pokemonEntity.name,
                        imageUrl = pokemonEntity.imageUrl,
                    )
                )
            }
        }
    }

    fun onRandomizeButtonClicked() {
        randomStringIdMutableLiveData.value = (1..898).random().toString()
    }
}