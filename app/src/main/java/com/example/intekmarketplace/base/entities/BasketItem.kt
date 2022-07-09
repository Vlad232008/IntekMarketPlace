package com.example.intekmarketplace.base.entities

import androidx.room.*
import java.io.Serializable

@Entity(tableName = "basket_item")
data class BasketItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "price")
    val price: Double,
    @ColumnInfo(name = "count")
    val count: Int,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "invCode")
    val invCode: String
) : Serializable
