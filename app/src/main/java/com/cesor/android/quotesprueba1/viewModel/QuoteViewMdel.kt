package com.cesor.android.quotesprueba1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cesor.android.quotesprueba1.model.QuoteModel
import com.cesor.android.quotesprueba1.model.QuoteProvider

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.viewModel
 * Created by: César Castro on 10/09/2022 at 13:29.
 ***/
class QuoteViewMdel : ViewModel(){
    var quoteModel = MutableLiveData<QuoteModel>()

    fun getRandomQuote(){
        val currentQuote = QuoteProvider.randomQuote()
        quoteModel.postValue(currentQuote)
    }
}