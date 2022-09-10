package com.cesor.android.quotesprueba1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.cesor.android.quotesprueba1.databinding.ActivityMainBinding
import com.cesor.android.quotesprueba1.viewModel.QuoteViewMdel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewMdel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObserver()
        binding.viewContainer.setOnClickListener { showQuote() }
    }

    private fun setupObserver() {
        quoteViewModel.quoteModel.observe(this) { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        }
    }

    private fun showQuote() {
        quoteViewModel.getRandomQuote()
    }
}