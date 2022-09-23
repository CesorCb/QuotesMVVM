package com.cesor.android.quotesprueba1.domain.model

import com.cesor.android.quotesprueba1.data.database.entities.QuoteEntity
import com.cesor.android.quotesprueba1.data.model.QuoteModel

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.domain.model
 * Created by: César Castro on 23/09/2022 at 17:41.
 ***/
data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)
