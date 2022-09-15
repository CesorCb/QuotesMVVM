package com.cesor.android.quotesprueba1.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.cesor.android.quotesprueba1.databinding.ActivityMainBinding
import com.cesor.android.quotesprueba1.ui.viewModel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()
        setupObservers()
        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }

    private fun setupObservers() {
        quoteViewModel.quoteModel.observe(this) { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        }
        quoteViewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.isVisible = isLoading

        }
    }
}