package com.cesor.android.quotesprueba1.domain

import com.cesor.android.quotesprueba1.data.QuoteRepository
import com.cesor.android.quotesprueba1.data.model.QuoteModel
import com.cesor.android.quotesprueba1.data.model.QuoteProvider

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.domain
 * Created by: César Castro on 13/09/2022 at 23:34.
 ***/
class GetRandomQuote {


    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}