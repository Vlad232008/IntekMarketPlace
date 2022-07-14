package com.example.intekmarketplace.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.intekmarketplace.MainApp
import com.example.intekmarketplace.adapter.BasketAdapter
import com.example.intekmarketplace.base.MainViewModel
import com.example.intekmarketplace.base.entities.BasketItem
import com.example.intekmarketplace.databinding.FragmentBasketBinding

class BasketFragment : Fragment(), BasketAdapter.Listener {
    private lateinit var binding: FragmentBasketBinding
    private lateinit var adapter: BasketAdapter
    private val mainViewModel: MainViewModel by activityViewModels {
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBasketBinding.inflate(inflater, container, false)
        initRcView()
        observer()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    private fun initRcView() = with(binding){
        rcViewBasket.layoutManager = LinearLayoutManager(activity)
        adapter = BasketAdapter(this@BasketFragment)
        rcViewBasket.adapter = adapter
    }


    private fun observer(){
        mainViewModel.allBasketItem.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BasketFragment()
    }

    override fun minusCount(basket:BasketItem) {
        val basketItem = BasketItem(basket.id,
            basket.name,
            basket.price,
            basket.count - 1,
            basket.description,
            basket.invCode
        )
        mainViewModel.updateBasketCount(basketItem)
    }

    override fun plusCount(basket: BasketItem) {
        val basketItem = BasketItem(basket.id,
            basket.name,
            basket.price,
            basket.count + 1,
            basket.description,
            basket.invCode
                )
        mainViewModel.updateBasketCount(basketItem)
    }

    override fun saleItem(basket: BasketItem) {

    }

    override fun deleteItem(id: Int) {
        mainViewModel.deleteBasket(id)
    }
}