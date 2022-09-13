package com.cesor.android.quotesprueba1.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesor.android.quotesprueba1.data.QuoteRepository
import com.cesor.android.quotesprueba1.data.model.QuoteModel
import com.cesor.android.quotesprueba1.domain.GetQuotes
import com.cesor.android.quotesprueba1.domain.GetRandomQuote
import kotlinx.coroutines.launch

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.ui.viewModel
 * Created by: César Castro on 10/09/2022 at 13:29.
 ***/
class QuoteViewModel : ViewModel() {
    var quoteModel = MutableLiveData<QuoteModel>()
    var isLoading = MutableLiveData<Boolean>()
    val getQuotes = GetQuotes()
    val getRandomQuote = GetRandomQuote()


    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotes()
            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuote()
        if (quote!= null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }
}