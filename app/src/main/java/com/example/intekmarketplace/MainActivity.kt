package com.example.intekmarketplace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.example.intekmarketplace.databinding.ActivityMainBinding
import com.example.intekmarketplace.fragment.HomeFragment
import com.example.intekmarketplace.manager.FragmentManager

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var saveItem: MenuItem
    private var currentMenuItemId = R.id.home
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FragmentManager.setFragment(HomeFragment.newInstance(), this)
        setBottomNavListener()
    }

    private fun setBottomNavListener(){
        binding.bNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.savelist -> {

                }
                R.id.home->{
                    currentMenuItemId = R.id.home
                    FragmentManager.setFragment(HomeFragment.newInstance(), this)
                }
                R.id.catalog->{
                    currentMenuItemId = R.id.catalog
                    //FragmentManager.setFragment(NoteFragment.newInstance(), this)
                }
                R.id.basket->{
                    //FragmentManager.currentFrag?.onClickNew()
                }
                R.id.profile->{
                    //startActivity(Intent(this, SettingActivity::class.java))
                }
            }
            true
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        saveItem = menu?.findItem(R.id.savelist)!!
        saveItem.isVisible = false
        val newItem = menu.findItem(R.id.newItem)
        newItem.setOnActionExpandListener(expandActionView())
        return true
    }
    private fun expandActionView(): MenuItem.OnActionExpandListener {
        return object : MenuItem.OnActionExpandListener {
            //При открытии поля ввода товара
            override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
                saveItem.isVisible = true
                return true
            }
            //при закрытии поля воода товара
            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                saveItem.isVisible = false
                return true
            }
        }
    }
}