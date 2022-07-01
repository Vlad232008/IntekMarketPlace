package com.example.intekmarketplace.manager

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.intekmarketplace.R

object FragmentManager {
    var currentFrag: Fragment? = null

    fun setFragment(newFrag: Fragment, activity: AppCompatActivity) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.placeHolder, newFrag)
        transaction.commit()
        currentFrag = newFrag
    }
}