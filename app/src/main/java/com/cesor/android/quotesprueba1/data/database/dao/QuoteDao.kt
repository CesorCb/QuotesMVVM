package com.cesor.android.quotesprueba1.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cesor.android.quotesprueba1.data.database.entities.QuoteEntity

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.data.database.dao
 * Created by: César Castro on 23/09/2022 at 00:02.
 ***/
@Dao
interface QuoteDao {
    @Query("SELECT * FROM quote_table ORDER BY author DESC")
    suspend fun getAllQuotes(): List<QuoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes: List<QuoteEntity>)

    @Query("DELETE FROM quote_table")
    suspend fun clearAllQuotes()
}