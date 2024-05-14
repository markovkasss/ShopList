package com.markovkasss.shoplist.domain

class RemoveShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun removeShopItem(shopItem: ShopItem){
        shopListRepository.removeShopItem(shopItem)
    }
}