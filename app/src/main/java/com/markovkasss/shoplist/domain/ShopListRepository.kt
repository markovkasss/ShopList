package com.markovkasss.shoplist.domain

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun removeShopItem(shopItem: ShopItem)

    fun getShopItemFromId(id: Int): ShopItem

    fun getShopList(): List<ShopItem>
}