package com.cesor.android.quotesprueba1.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.core
 * Created by: César Castro on 13/09/2022 at 23:17.
 ***/
object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}