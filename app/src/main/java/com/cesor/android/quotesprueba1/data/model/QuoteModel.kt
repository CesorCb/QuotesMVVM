package com.cesor.android.quotesprueba1.data.model

import com.google.gson.annotations.SerializedName

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.data.model
 * Created by: César Castro on 10/09/2022 at 13:25.
 ***/
data class QuoteModel(
    @SerializedName("quote") val quote: String,
    @SerializedName("author") val author: String
)
