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

class TovAdapter() :
    ListAdapter<TovItem, TovAdapter.ItemHolder>(ItemComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position))
    }

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = TovAdapterBinding.bind(view)
        private val imageList: MutableList<String> = mutableListOf("10\\1097","ХК298","ХК108")
        private var count = 0
        fun setData(tov: TovItem) = with(binding) {
            tvName.text = tov.name
            tvPrice.text = tov.price.toString()
            count = Random.nextInt(0, 3)
            val url = "https://intekopt.ru/upload/photo/" + getPictureFileName(imageList[count].trim()).replace(".gif","/0.jpg")
            Picasso.get()
                .load(url)
                .error(R.drawable.ic_baseline_home_24)
                .into(ivPhoto)
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
        fun getPictureFileName(InvCode:String):String    {
            val invcode = InvCode.toLowerCase(Locale.ROOT)
            var result = ""
            for ( i in invcode.indices)
            {
                when (invcode.substring(i, i+1))
                {
                    "й" -> result += "iy"
                    "ц" -> result += "cc"
                    "у" -> result += "u"
                    "к" -> result += "k"
                    "е" -> result += "e"
                    "н" -> result += "n"
                    "г" -> result += "g"
                    "ш" -> result += "h"
                    "щ" -> result += "dg"
                    "з" -> result += "z"
                    "х" -> result += "x"
                    "ъ" -> result += "dl"
                    "ф" -> result += "f"
                    "ы" -> result += "y"
                    "в" -> result += "v"
                    "а" -> result += "a"
                    "п" -> result += "p"
                    "р" -> result += "r"
                    "о" -> result += "o"
                    "л" -> result += "l"
                    "д" -> result += "d"
                    "ж" -> result += "j"
                    "э" -> result += "w"
                    "я" -> result += "ya"
                    "ч" -> result += "ch"
                    "с" -> result += "s"
                    "м" -> result += "m"
                    "и" -> result += "i"
                    "т" -> result += "t"
                    "ь" -> result += "zz"
                    "б" -> result += "b"
                    "ю" -> result += "q"
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


}