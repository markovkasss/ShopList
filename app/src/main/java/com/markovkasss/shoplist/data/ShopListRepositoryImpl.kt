package com.markovkasss.shoplist.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.markovkasss.shoplist.domain.ShopItem
import com.markovkasss.shoplist.domain.ShopListRepository
import kotlin.random.Random

class ShopListRepositoryImpl(application: Application) : ShopListRepository {

    private val shopListDao = AppDatabase.getInstance(application).shopListDao()
    private val mapper = ShopListMapper()

    override fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override fun editShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopListDao.deleteShopItem(shopItem.id)
    }

    override fun getShopItemFromId(id: Int): ShopItem {
        val dbModel = shopListDao.getShopItem(id)
        return mapper.mapDbModelToEntity(dbModel)
    }

    override fun getShopList(): LiveData<List<ShopItem>> = MediatorLiveData<List<ShopItem>>().apply {
        addSource(shopListDao.getShopList()) {
            value = mapper.mapListDbModelToListEntity(it)
        }
    }
}