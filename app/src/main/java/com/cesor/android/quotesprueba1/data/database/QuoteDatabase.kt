package com.cesor.android.quotesprueba1.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cesor.android.quotesprueba1.data.database.dao.QuoteDao
import com.cesor.android.quotesprueba1.data.database.entities.QuoteEntity

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.data.database
 * Created by: César Castro on 23/09/2022 at 17:34.
 ***/
@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao
}