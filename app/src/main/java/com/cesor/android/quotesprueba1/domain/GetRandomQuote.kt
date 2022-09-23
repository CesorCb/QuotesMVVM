package com.cesor.android.quotesprueba1.domain

import com.cesor.android.quotesprueba1.data.QuoteRepository
import com.cesor.android.quotesprueba1.domain.model.Quote
import javax.inject.Inject

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.domain
 * Created by: César Castro on 13/09/2022 at 23:34.
 ***/
class GetRandomQuote @Inject constructor(private val quoteRepository: QuoteRepository) {

    suspend operator fun invoke(): Quote? {
        val quotes = quoteRepository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}