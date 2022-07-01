package com.example.intekmarketplace.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.intekmarketplace.MainApp
import com.example.intekmarketplace.TovAdapter
import com.example.intekmarketplace.base.MainViewModel
import com.example.intekmarketplace.base.entities.TovItem
import com.example.intekmarketplace.databinding.FragmentNoteBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentNoteBinding
    private lateinit var adapter: TovAdapter
    private val mainViewModel: MainViewModel by activityViewModels {
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        insertTov()
        initRcView()
        observer()
        return binding.root
    }
/*    private fun onEditResult(){
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == Activity.RESULT_OK){
                val editState = it.data?.getStringExtra(EDIT_STATE_KEY)
                if (editState == "update"){
                    mainViewModel.updateNote(it.data?.getSerializableExtra(NEW_NOTE_KEY) as NoteItem)
                }
                else {
                    mainViewModel.insertNote(it.data?.getSerializableExtra(NEW_NOTE_KEY) as NoteItem)
                }
            }
        }
    }*/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    private fun initRcView() = with(binding){

        rcViewNote.layoutManager = GridLayoutManager(activity, 2)
        adapter = TovAdapter()
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
        val table = TovItem(
            null,
            "table",
            2000,
        )
        val door = TovItem(
            null,
            "door",
            500,
        )
        val room = TovItem(
            null,
            "room",
            1000,
        )
        mainViewModel.insertTov(door)
    }
}