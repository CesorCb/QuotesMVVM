package com.cesor.android.quotesprueba1.domain

import com.cesor.android.quotesprueba1.data.QuoteRepository
import com.cesor.android.quotesprueba1.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.domain
 * Created by: César Castro on 7/10/2022 at 11:57.
 */
class GetRandomQuoteTest{

    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository
    lateinit var getRandomQuote: GetRandomQuote

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getRandomQuote = GetRandomQuote(quoteRepository)
    }

    @Test
    fun whenDatabaseIsEmptyThenReturnNull() = runBlocking {
        //Given
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns emptyList()
        //When
        val response = getRandomQuote()
        //Then
        assert(response == null)
    }

    @Test
    fun whenDatabaseIsNotEmptyThenReturnQuote()= runBlocking {
        //Given
        val myList = listOf(Quote("ey", "Csor"))
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns myList
        //When
        val response = getRandomQuote()
        //Then
        assert(response == myList.first())
    }
}