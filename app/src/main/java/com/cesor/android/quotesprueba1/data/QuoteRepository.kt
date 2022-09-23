package com.cesor.android.quotesprueba1.data

import com.cesor.android.quotesprueba1.data.database.dao.QuoteDao
import com.cesor.android.quotesprueba1.data.database.entities.QuoteEntity
import com.cesor.android.quotesprueba1.data.network.QuoteService
import com.cesor.android.quotesprueba1.domain.model.Quote
import com.cesor.android.quotesprueba1.domain.model.toDomain
import javax.inject.Inject

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.data
 * Created by: César Castro on 13/09/2022 at 23:24.
 ***/
class QuoteRepository @Inject constructor(private val api: QuoteService, private val quoteDao: QuoteDao) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote>{
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearAllQuotes(){
        quoteDao.clearAllQuotes()
    }
}