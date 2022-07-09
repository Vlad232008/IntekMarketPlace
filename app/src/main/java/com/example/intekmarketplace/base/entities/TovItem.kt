package com.example.intekmarketplace.base.entities

import androidx.room.*
import java.io.Serializable

@Entity(tableName = "tov_item")
data class TovItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "price")
    val price: Double,
    @ColumnInfo(name = "invCode")
    val invCode: String
) : Serializable
