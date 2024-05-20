package com.markovkasss.shoplist.presentetion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.markovkasss.shoplist.R
import com.markovkasss.shoplist.domain.ShopItem

class ShopListAdapter : ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {

    companion object {
        const val ITEM_ENABLED = 1
        const val ITEM_DISABLED = 0

        const val MAX_PULL_SIZE = 30
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
        val shopItem = getItem(position)
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

    override fun getItemViewType(position: Int): Int {
        val shopItem = getItem(position)
        return if (shopItem.enabled) {
            ITEM_ENABLED
        } else {
            ITEM_DISABLED
        }
    }
}