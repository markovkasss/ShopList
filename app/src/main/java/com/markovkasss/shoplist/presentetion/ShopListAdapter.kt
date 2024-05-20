package com.markovkasss.shoplist.presentetion

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.markovkasss.shoplist.R
import com.markovkasss.shoplist.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    companion object {
        const val ITEM_ENABLED = 1
        const val ITEM_DISABLED = 0

        const val MAX_PULL_SIZE = 30
    }

    var shopList = listOf<ShopItem>()
        set(value) {
            val callback = ShopListDiffCallback(shopList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }


    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val view: View
        when (viewType) {
            ITEM_ENABLED -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_shop_enabled,
                    parent,
                    false
                )
            }

            else -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_shop_disabled,
                    parent,
                    false
                )
            }
        }
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        Log.d("ShopListAdapter", "onBindViewHolder")
        val shopItem = shopList[position]
        viewHolder.view.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        viewHolder.view.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
            true
        }
        if (shopItem.enabled) {
            viewHolder.textViewName.text = shopItem.name
            viewHolder.textViewCount.text = shopItem.count.toString()
        } else {
            viewHolder.textViewName.text = shopItem.name
            viewHolder.textViewCount.text = shopItem.count.toString()
        }
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    override fun getItemViewType(position: Int): Int {
        val shopItem = shopList[position]
        return if (shopItem.enabled) {
            ITEM_ENABLED
        } else {
            ITEM_DISABLED
        }
    }

    class ShopItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textViewName = view.findViewById<TextView>(R.id.tv_name)
        val textViewCount = view.findViewById<TextView>(R.id.tv_count)
    }


}