package com.cesor.android.quotesprueba1.data.network

import com.cesor.android.quotesprueba1.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.data.network
 * Created by: César Castro on 13/09/2022 at 23:21.
 ***/
class QuoteService @Inject constructor(private val api: QuoteApiClient) {


    suspend fun getQuotes(): List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}