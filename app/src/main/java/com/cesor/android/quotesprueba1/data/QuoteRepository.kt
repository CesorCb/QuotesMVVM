package com.cesor.android.quotesprueba1.data

import com.cesor.android.quotesprueba1.data.model.QuoteModel
import com.cesor.android.quotesprueba1.data.model.QuoteProvider
import com.cesor.android.quotesprueba1.data.network.QuoteService
import javax.inject.Inject

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.data
 * Created by: César Castro on 13/09/2022 at 23:24.
 ***/
class QuoteRepository @Inject constructor(private val api: QuoteService, private val quoteProvider: QuoteProvider) {

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }

}