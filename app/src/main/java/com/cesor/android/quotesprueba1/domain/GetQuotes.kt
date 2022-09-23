package com.cesor.android.quotesprueba1.domain

import com.cesor.android.quotesprueba1.data.QuoteRepository
import com.cesor.android.quotesprueba1.data.database.entities.toDatabase
import com.cesor.android.quotesprueba1.domain.model.Quote
import javax.inject.Inject

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.domain
 * Created by: César Castro on 13/09/2022 at 23:26.
 ***/
class GetQuotes @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<Quote>{
        val quotes = repository.getAllQuotesFromApi()
        return if (quotes.isNotEmpty()){
            repository.clearAllQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }
}