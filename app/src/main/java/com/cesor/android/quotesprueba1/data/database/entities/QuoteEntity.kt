package com.cesor.android.quotesprueba1.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cesor.android.quotesprueba1.domain.model.Quote

/****
 * Project: QuotesPrueba1
 * From: com.cesor.android.quotesprueba1.data.database.entities
 * Created by: César Castro on 23/09/2022 at 15:22.
 ***/
@Entity(tableName = "quote_table")
data class QuoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "quote") val quote: String
)

fun Quote.toDatabase(): QuoteEntity = QuoteEntity(author = author, quote = quote)
