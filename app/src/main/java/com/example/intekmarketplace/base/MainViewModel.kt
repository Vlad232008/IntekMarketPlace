package com.example.intekmarketplace.base

import androidx.lifecycle.*
import com.example.intekmarketplace.base.entities.TovItem
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MainViewModel(database: MainDataBase):ViewModel() {
    val dao = database.getDao()

    val allTovItem: LiveData<List<TovItem>> = dao.getAllTov().asLiveData()

    fun insertTov(tov:TovItem) = viewModelScope.launch {
        dao.insertTov(tov)
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