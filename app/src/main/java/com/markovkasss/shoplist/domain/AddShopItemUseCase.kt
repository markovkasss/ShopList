package com.markovkasss.shoplist.domain

import com.markovkasss.shoplist.domain.ShopItem

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem){
        shopListRepository.addShopItem(shopItem)
    }
}