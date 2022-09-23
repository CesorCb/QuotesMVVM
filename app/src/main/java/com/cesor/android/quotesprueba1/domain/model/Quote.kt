package com.cesor.android.quotesprueba1.domain.model

import com.cesor.android.quotesprueba1.data.database.entities.QuoteEntity
import com.cesor.android.quotesprueba1.data.model.QuoteModel

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.domain.model
 * Created by: César Castro on 23/09/2022 at 00:41.
 ***/
data class Quote(val author: String, val quote: String)

fun QuoteModel.toDomain() = Quote(author, quote)

fun QuoteEntity.toDomain() = Quote(author, quote)