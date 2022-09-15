package com.cesor.android.quotesprueba1.data.model

import javax.inject.Inject
import javax.inject.Singleton

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.data.model
 * Created by: César Castro on 10/09/2022 at 13:25.
 ***/
@Singleton
class QuoteProvider @Inject constructor() {
        var quotes: List<QuoteModel> = emptyList()
}