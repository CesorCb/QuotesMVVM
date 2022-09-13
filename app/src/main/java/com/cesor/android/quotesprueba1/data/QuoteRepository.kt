package com.cesor.android.quotesprueba1.data

import com.cesor.android.quotesprueba1.data.model.QuoteModel
import com.cesor.android.quotesprueba1.data.model.QuoteProvider
import com.cesor.android.quotesprueba1.data.network.QuoteService
/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.data.model
 * Created by: César Castro on 12/09/2022 at 21:26.
 ***/
class QuoteRepository {
    private val api = QuoteService()
    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}

