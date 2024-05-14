package com.markovkasss.shoplist.domain

import com.markovkasss.shoplist.domain.ShopItem

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem){
        shopListRepository.editShopItem(shopItem)
    }
}