package com.emplk.pokedeks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emplk.pokedeks.databinding.MainActivityBinding
import com.emplk.pokedeks.ui.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding { MainActivityBinding.inflate(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
    }
}