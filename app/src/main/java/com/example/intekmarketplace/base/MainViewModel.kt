package com.example.intekmarketplace.base

import androidx.lifecycle.*
import com.example.intekmarketplace.base.entities.BasketItem
import com.example.intekmarketplace.base.entities.TovItem
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MainViewModel(database: MainDataBase):ViewModel() {
    private val dao = database.getDao()

    val allTovItem: LiveData<List<TovItem>> = dao.getAllTov().asLiveData()

    val allBasketItem: LiveData<List<BasketItem>> = dao.getAllBasketItem().asLiveData()

    fun insertTov(tov:TovItem) = viewModelScope.launch {
        dao.insertTov(tov)
    }

    fun insertBasket(basket:BasketItem) = viewModelScope.launch {
        dao.insertBasketItem(basket)
    }

    fun updateBasketCount(basket:BasketItem) = viewModelScope.launch {
        dao.updateBasket(basket)
    }

    class MainViewModelFactory(private val database: MainDataBase): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(MainViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(database) as T
            }
            throw IllegalArgumentException("Unknows ViewModelClass")
        }
    }
}