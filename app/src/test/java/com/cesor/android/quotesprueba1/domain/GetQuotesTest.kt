package com.cesor.android.quotesprueba1.domain

import com.cesor.android.quotesprueba1.data.QuoteRepository
import com.cesor.android.quotesprueba1.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.domain
 * Created by: César Castro on 7/10/2022 at 11:22.
 */
class GetQuotesTest{
    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    lateinit var getQuotes: GetQuotes

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getQuotes = GetQuotes(quoteRepository)
    }

    @Test
    fun whenTheApiDoesntReturnsAnythingThenGetValuesFromDatabase() = runBlocking {
        //Given
        coEvery { quoteRepository.getAllQuotesFromApi() } returns emptyList()
        //When
        getQuotes()
        //Then
        coVerify(exactly = 0) { quoteRepository.clearQuotes() }
        coVerify(exactly = 0) { quoteRepository.insertQuotes(any()) }
        coVerify(exactly = 1) { quoteRepository.getAllQuotesFromDatabase() }
    }

    @Test
    fun whenTheApiReturnsSomethingThenGetValuesFromApi() = runBlocking {
        //Given
        val myList = listOf(Quote("ey", "Csor"))
        coEvery { quoteRepository.getAllQuotesFromApi() } returns myList
        //When
        val response = getQuotes()
        //Then
        coVerify(exactly = 1) { quoteRepository.clearQuotes() }
        coVerify(exactly = 1) { quoteRepository.insertQuotes(any()) }
        coVerify(exactly = 0) { quoteRepository.getAllQuotesFromDatabase() }
        assert(myList == response)
    }
}