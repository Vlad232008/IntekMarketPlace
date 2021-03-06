package com.example.intekmarketplace.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.intekmarketplace.R
import com.example.intekmarketplace.base.entities.TovItem
import com.example.intekmarketplace.databinding.TovAdapterBinding
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.random.Random

class TovAdapter(private val listener : Listener) :
    ListAdapter<TovItem, TovAdapter.ItemHolder>(ItemComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position), listener)
    }

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = TovAdapterBinding.bind(view)
        private var count = 0
        fun setData(tov: TovItem, listener: Listener) = with(binding) {
            tvName.text = tov.name
            tvPrice.text = tov.price.toString()
            val url = "https://intekopt.ru/upload/photo/" + getPictureFileName(tov.invCode.trim()).replace(".gif","/0.jpg")
            Picasso.get()
                .load(url)
                .error(R.drawable.ic_baseline_home_24)
                .into(ivPhoto)

            btnAddItem.setOnClickListener {
                listener.addItemBasket(tov)
            }
            //ivPhoto.setImageResource(R.drawable.ic_baseline_manage_accounts_24)
            /*itemView.setOnClickListener{
                listener.onClickItem(tov)
            }
            imDelete.setOnClickListener {
                listener.deleteItem(note.id!!)
            }*/
        }

        companion object {
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.tov_adapter, parent, false)
                )
            }
        }
        private fun getPictureFileName(InvCode:String):String    {
            val invcode = InvCode.toLowerCase(Locale.ROOT)
            var result = ""
            for ( i in invcode.indices)
            {
                when (invcode.substring(i, i+1))
                {
                    "??" -> result += "iy"
                    "??" -> result += "cc"
                    "??" -> result += "u"
                    "??" -> result += "k"
                    "??" -> result += "e"
                    "??" -> result += "n"
                    "??" -> result += "g"
                    "??" -> result += "h"
                    "??" -> result += "dg"
                    "??" -> result += "z"
                    "??" -> result += "x"
                    "??" -> result += "dl"
                    "??" -> result += "f"
                    "??" -> result += "y"
                    "??" -> result += "v"
                    "??" -> result += "a"
                    "??" -> result += "p"
                    "??" -> result += "r"
                    "??" -> result += "o"
                    "??" -> result += "l"
                    "??" -> result += "d"
                    "??" -> result += "j"
                    "??" -> result += "w"
                    "??" -> result += "ya"
                    "??" -> result += "ch"
                    "??" -> result += "s"
                    "??" -> result += "m"
                    "??" -> result += "i"
                    "??" -> result += "t"
                    "??" -> result += "zz"
                    "??" -> result += "b"
                    "??" -> result += "q"
                    "\\" -> result += "ls"
                    "/" -> result += "ps"
                    "1" -> result += "1"
                    "2" -> result += "2"
                    "3" -> result += "3"
                    "4" -> result += "4"
                    "5" -> result += "5"
                    "6" -> result += "6"
                    "7" -> result += "7"
                    "8" -> result += "8"
                    "9" -> result += "9"
                    "0" -> result += "0"
                }
            }
            return "$result.gif"
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<TovItem>() {
        override fun areItemsTheSame(oldItem: TovItem, newItem: TovItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TovItem, newItem: TovItem): Boolean {
            return oldItem == newItem
        }
    }

    interface Listener {
        fun addItemBasket(tov: TovItem)
    }
}