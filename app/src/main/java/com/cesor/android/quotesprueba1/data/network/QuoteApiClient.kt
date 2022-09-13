package com.cesor.android.quotesprueba1.data.network

import com.cesor.android.quotesprueba1.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.data.model
 * Created by: César Castro on 12/09/2022 at 21:20.
 ***/
interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}