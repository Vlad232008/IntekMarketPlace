package com.example.intekmarketplace

import android.app.Application
import com.example.intekmarketplace.base.MainDataBase

class MainApp: Application(){
    val database by lazy { MainDataBase.getDataBase(this)}
}