package com.example.intekmarketplace.base.dao

import androidx.room.*
import androidx.room.Dao
import com.example.intekmarketplace.base.entities.TovItem
import kotlinx.coroutines.flow.Flow


@Dao
interface Dao {
    @Query("SELECT* From tov_item")
    fun getAllTov(): Flow<List<TovItem>>
    @Insert
    suspend fun insertTov(tov: TovItem)
}

