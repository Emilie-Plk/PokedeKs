package com.emplk.pokedeks.ui

import android.os.Bundle
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.emplk.pokedeks.databinding.MainActivityBinding
import com.emplk.pokedeks.ui.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding { MainActivityBinding.inflate(it) }
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.viewStateLiveData.observe(this) { pokemonViewState ->
            binding.pokemonName.text = pokemonViewState.name
            Glide.with(this)
                .load(pokemonViewState.imageUrl)
                .into(binding.pokemonImage)
        }

        binding.randomPokemonBtn.setOnClickListener {
            viewModel.onRandomizeButtonClicked()
        }
    }
}