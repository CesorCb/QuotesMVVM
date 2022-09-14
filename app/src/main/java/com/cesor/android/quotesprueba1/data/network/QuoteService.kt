package com.cesor.android.quotesprueba1.data.network

import com.cesor.android.quotesprueba1.core.RetrofitHelper
import com.cesor.android.quotesprueba1.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.data.network
 * Created by: César Castro on 13/09/2022 at 23:21.
 ***/
class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}