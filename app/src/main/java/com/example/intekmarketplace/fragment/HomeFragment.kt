package com.example.intekmarketplace.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.intekmarketplace.MainApp
import com.example.intekmarketplace.adapter.TovAdapter
import com.example.intekmarketplace.base.MainViewModel
import com.example.intekmarketplace.base.entities.BasketItem
import com.example.intekmarketplace.base.entities.TovItem
import com.example.intekmarketplace.databinding.FragmentNoteBinding
import kotlin.random.Random

class HomeFragment : Fragment(),TovAdapter.Listener {
    private lateinit var binding: FragmentNoteBinding
    private lateinit var adapter: TovAdapter
    private val mainViewModel: MainViewModel by activityViewModels {
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        insertTov()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        initRcView()
        observer()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    private fun initRcView() = with(binding){

        rcViewNote.layoutManager = GridLayoutManager(activity, 2)
        adapter = TovAdapter(this@HomeFragment)
        rcViewNote.adapter = adapter
    }


    private fun observer(){
        mainViewModel.allTovItem.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    companion object {
        /*const val NEW_NOTE_KEY = "new_note_key"
        const val EDIT_STATE_KEY = "edit_state_key"
        */
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    private fun insertTov(){
        when (Random.nextInt(0, 3)) {
            0 -> {
                val table = TovItem(
                    null,
                    "table",
                    2000,
                    ""
                )
                mainViewModel.insertTov(table)
            }
            1-> {
                val door = TovItem(
                    null,
                    "door",
                    500,
                    ""
                )
                mainViewModel.insertTov(door)
            }
            else -> {
                val room = TovItem(
                    null,
                    "room",
                    1000,
                    ""
                )
                mainViewModel.insertTov(room)
            }
        }

    }

    override fun addItemBasket(tov: TovItem) {
        val basketItem = BasketItem(
            null,
            tov.name,
            tov.price,
            1,
            "",
            tov.invCode
        )
        mainViewModel.insertBasket(basketItem)
    }
}