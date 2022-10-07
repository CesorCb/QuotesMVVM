package com.cesor.android.quotesprueba1.ui.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cesor.android.quotesprueba1.domain.GetQuotes
import com.cesor.android.quotesprueba1.domain.GetRandomQuote
import com.cesor.android.quotesprueba1.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.ui.viewModel
 * Created by: César Castro on 7/10/2022 at 12:57.
 */
@ExperimentalCoroutinesApi
class QuoteViewModelTest {
    @RelaxedMockK
    private lateinit var getQuotes: GetQuotes

    @RelaxedMockK
    private lateinit var getRandomQuote: GetRandomQuote

    private lateinit var quoteViewModel: QuoteViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        quoteViewModel = QuoteViewModel(getRandomQuote, getQuotes)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun whenViewModelIsCreatedAtTheFirstTimeGetAllQuotesAndSetTheFirstValue() = runTest {
        //Given
        val myList = listOf(Quote("ey", "Csor"), Quote("ola", "Andre"))
        coEvery { getQuotes() } returns myList
        //When
        quoteViewModel.onCreate()
        //Then
        assert(quoteViewModel.quoteModel.value == myList.first())
    }

    @Test
    fun whenRandomQuoteReturnAQuoteSetOnTheLiveData() = runTest {
        //Given
        val myQuote = Quote("ey", "Csor")
        coEvery { getRandomQuote() } returns myQuote
        //When
        quoteViewModel.randomQuote()
        //Then
        assert(quoteViewModel.quoteModel.value == myQuote)
    }

    @Test
    fun ifRandomQuoteReturnNullKeepTheLastValue() = runTest {
        //Given
        val myQuote = Quote("ey", "Csor")
        quoteViewModel.quoteModel.value = myQuote
        //When
        coEvery { getRandomQuote() } returns null
        //Then
        assert(quoteViewModel.quoteModel.value == myQuote)
    }
}