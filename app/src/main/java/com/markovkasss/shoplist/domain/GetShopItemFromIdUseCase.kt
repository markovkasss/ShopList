package com.markovkasss.shoplist.domain

import com.markovkasss.shoplist.domain.ShopItem

class GetShopItemFromIdUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItemFromId(id: Int): ShopItem {
        return shopListRepository.getShopItemFromId(id)
    }
}