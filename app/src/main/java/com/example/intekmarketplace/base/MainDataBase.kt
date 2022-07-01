package com.example.intekmarketplace.base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.intekmarketplace.base.dao.Dao
import com.example.intekmarketplace.base.entities.LibraryItem
import com.example.intekmarketplace.base.entities.TovItem

@Database(entities = [LibraryItem::class,TovItem::class], version = 1)
abstract class MainDataBase:RoomDatabase() {
    abstract fun getDao(): Dao

    companion object{
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getDataBase(context: Context):MainDataBase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                MainDataBase::class.java,
                "intek_tov.db"
                ).build()
                instance
            }
        }
    }
}