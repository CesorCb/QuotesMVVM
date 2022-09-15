package com.cesor.android.quotesprueba1.domain

import com.cesor.android.quotesprueba1.data.QuoteRepository
import com.cesor.android.quotesprueba1.data.model.QuoteModel
import com.cesor.android.quotesprueba1.data.model.QuoteProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.domain
 * Created by: César Castro on 13/09/2022 at 23:26.
 ***/
class GetQuotes @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<QuoteModel> = repository.getAllQuotes()
}