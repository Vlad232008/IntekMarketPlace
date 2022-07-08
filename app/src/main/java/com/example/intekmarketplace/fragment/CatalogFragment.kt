package com.example.intekmarketplace.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.intekmarketplace.adapter.CatalogAdapter
import com.example.intekmarketplace.databinding.FragmentCatalogBinding

class CatalogFragment : Fragment() {
    private lateinit var binding: FragmentCatalogBinding
    private lateinit var adapter: CatalogAdapter
    private val catalogList: List<String> = mutableListOf("Женщинам","Мужчинам","Детям","Канцтовары","Товары для дома","Мебель", "ХозТовары")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatalogBinding.inflate(inflater, container, false)
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