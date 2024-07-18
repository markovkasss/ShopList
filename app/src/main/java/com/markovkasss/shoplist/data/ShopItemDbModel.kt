package com.markovkasss.shoplist.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.markovkasss.shoplist.domain.ShopItem
@Entity("shop_items")
data class ShopItemDbModel(
    @PrimaryKey(true)
    val id: Int,
    val name: String,
    val count: Int,
    val enabled: Boolean
)
