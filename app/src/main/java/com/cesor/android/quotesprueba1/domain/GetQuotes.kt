package com.cesor.android.quotesprueba1.domain

import com.cesor.android.quotesprueba1.data.QuoteRepository
import com.cesor.android.quotesprueba1.data.model.QuoteModel

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.domain
 * Created by: César Castro on 12/09/2022 at 21:30.
 ***/
class GetQuotes {
    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel> = repository.getAllQuotes()
}