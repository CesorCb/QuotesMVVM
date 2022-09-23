package com.cesor.android.quotesprueba1.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cesor.android.quotesprueba1.data.database.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.di
 * Created by: César Castro on 23/09/2022 at 00:07.
 ***/
@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "quote_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, QuoteDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(dt: QuoteDatabase) = dt.getQuoteDao()
}