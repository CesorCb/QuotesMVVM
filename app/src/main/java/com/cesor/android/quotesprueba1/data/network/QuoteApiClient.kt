package com.cesor.android.quotesprueba1.data.network

import com.cesor.android.quotesprueba1.core.RetrofitHelper
import com.cesor.android.quotesprueba1.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.data.network
 * Created by: César Castro on 13/09/2022 at 23:19.
 ***/
interface QuoteApiClient {

    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}