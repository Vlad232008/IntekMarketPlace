package com.example.intekmarketplace.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.intekmarketplace.MainApp
import com.example.intekmarketplace.adapter.CatalogAdapter
import com.example.intekmarketplace.adapter.TovAdapter
import com.example.intekmarketplace.base.MainViewModel
import com.example.intekmarketplace.base.entities.TovItem
import com.example.intekmarketplace.databinding.CatalogAdapterBinding
import com.example.intekmarketplace.databinding.FragmentNoteBinding

class CatalogFragment : Fragment() {
    private lateinit var binding: CatalogAdapterBinding
    private lateinit var adapter: CatalogAdapter
    private val catalogList: List<String> = mutableListOf("Женщинам","Мужчинам","Пидорам","Дотерам","Анальным контрабандистам","Менструальным фетишистам")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CatalogAdapterBinding.inflate(inflater, container, false)
        initRcView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initRcView() = with(binding){
        rcViewCatalog.layoutManager = LinearLayoutManager(activity)
        adapter = CatalogAdapter(catalogList)
        rcViewCatalog.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = CatalogFragment()
    }
}