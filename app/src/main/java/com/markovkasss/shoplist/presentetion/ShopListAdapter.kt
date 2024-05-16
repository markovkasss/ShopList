package com.markovkasss.shoplist.presentetion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.markovkasss.shoplist.R
import com.markovkasss.shoplist.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_shop_disabled,
            parent,
            false
        )
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        val shopItem = shopList[position]
        val status = if (shopItem.enabled){
            "Active"
        } else {
            "Not active"
        }

        viewHolder.view.setOnLongClickListener {
            true
        }
        if (shopItem.enabled){
            viewHolder.textViewName.text = "${shopItem.name} $status"
            viewHolder.textViewCount.text = shopItem.count.toString()
            viewHolder.textViewName.setTextColor(ContextCompat.getColor(viewHolder.view.context, android.R.color.holo_red_light))
        }
    }

    override fun onViewRecycled(viewHolder: ShopItemViewHolder) {
        super.onViewRecycled(viewHolder)
        viewHolder.textViewName.text = ""
        viewHolder.textViewCount.text = ""
        viewHolder.textViewName.setTextColor(ContextCompat.getColor(viewHolder.view.context, android.R.color.white))
    }

    override fun getItemCount(): Int {
        return shopList.size
    }



    class ShopItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textViewName = view.findViewById<TextView>(R.id.tv_name)
        val textViewCount = view.findViewById<TextView>(R.id.tv_count)
    }
}