package com.markovkasss.shoplist.presentetion

import androidx.lifecycle.ViewModel
import com.markovkasss.shoplist.data.ShopListRepositoryImpl
import com.markovkasss.shoplist.domain.AddShopItemUseCase
import com.markovkasss.shoplist.domain.EditShopItemUseCase
import com.markovkasss.shoplist.domain.GetShopItemFromIdUseCase
import com.markovkasss.shoplist.domain.ShopItem
import java.io.DataInput

class ShopItemViewModel : ViewModel() {
    val repository = ShopListRepositoryImpl

    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val getShopItemFromIdUseCase = GetShopItemFromIdUseCase(repository)

    fun editShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (fieldsValid){
            val shopItem = ShopItem(name, count, true)
            editShopItemUseCase.editShopItem(shopItem)
        }
    }

    fun addHopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (fieldsValid){
            val shopItem = ShopItem(name, count, true)
            addShopItemUseCase.addShopItem(shopItem)
        }
    }

    fun getShopItemFromId(shopItemId: Int) {
        val item = getShopItemFromIdUseCase.getShopItemFromId(shopItemId)
    }

    private fun parseName(inputName: String?): String{
        return inputName?.trim() ?:""
    }

    private fun parseCount(inputCount: String?) : Int{
        return try {
            inputCount?.trim()?.toInt() ?:0
        } catch (e : Exception){
            0
        }
    }

    private fun validateInput(name: String, count: Int): Boolean{
        val result = true
        if (name.isBlank()){
            //TODO: SHOW ERROR INPUT NAME
            result = false
        }
        if (count <= 0){
            //TODO: SHOW ERROR INPUT COUNT
            result = false
        }
        return result
    }
}