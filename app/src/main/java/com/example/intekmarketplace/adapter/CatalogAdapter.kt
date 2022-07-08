package com.example.intekmarketplace.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.intekmarketplace.R
import com.example.intekmarketplace.databinding.ItemCatalogBinding

class CatalogAdapter(private val names:List<String>) :
    RecyclerView.Adapter<CatalogAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemCatalogBinding.bind(itemView)
        companion object {
            fun create(parent: ViewGroup): MyViewHolder {
                return MyViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_catalog, parent, false)
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.catalogName.text = names[position]
    }

    override fun getItemCount(): Int {
        return names.size
    }
    /*interface Listener{
        fun onClickItem(catalog: List<String>, position: Int)
    }*/
}