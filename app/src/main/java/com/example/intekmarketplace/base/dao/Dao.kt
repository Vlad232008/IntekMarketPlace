package com.example.intekmarketplace.base.dao

import androidx.room.*
import androidx.room.Dao
import com.example.intekmarketplace.base.entities.BasketItem
import com.example.intekmarketplace.base.entities.TovItem
import kotlinx.coroutines.flow.Flow


@Dao
interface Dao {
    @Query("SELECT* From tov_item")
    fun getAllTov(): Flow<List<TovItem>>

    @Query("Select* From basket_item")
    fun getAllBasketItem(): Flow<List<BasketItem>>

    @Query("Delete from basket_item where id is :id")
    suspend fun deleteBasketItem(id:Int)

    @Update
    suspend fun updateBasket(item: BasketItem)

    @Insert
    suspend fun insertTov(tov: TovItem)

    @Insert
    suspend fun insertBasketItem(item: BasketItem)
}

