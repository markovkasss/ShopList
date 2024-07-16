package com.markovkasss.shoplist.presentetion

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.markovkasss.shoplist.R
import java.lang.Error

@BindingAdapter("errorInputName")
fun bindErrorInputName(textInputLayout: TextInputLayout, isError: Boolean){
    val message = if (isError) {
        textInputLayout.context.getString(R.string.enter_name_error)
    } else {
        null
    }
    textInputLayout.error = message
}

@BindingAdapter("errorInputCount")
fun bindErrorInputCount(textInputLayout: TextInputLayout, isError: Boolean){
    val message = if (isError) {
        textInputLayout.context.getString(R.string.enter_count_error)
    } else {
        null
    }
    textInputLayout.error = message
}