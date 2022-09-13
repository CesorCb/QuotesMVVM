package com.cesor.android.quotesprueba1.data.network

import com.cesor.android.quotesprueba1.core.RetrofitHelper
import com.cesor.android.quotesprueba1.data.model.QuoteModel
import com.cesor.android.quotesprueba1.data.model.QuoteProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.data.network
 * Created by: César Castro on 12/09/2022 at 21:21.
 ***/
class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
             response.body() ?: emptyList()
        }
    }
}