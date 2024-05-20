package com.markovkasss.shoplist.presentetion

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.markovkasss.shoplist.R

class ShopItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val textViewName = view.findViewById<TextView>(R.id.tv_name)
    val textViewCount = view.findViewById<TextView>(R.id.tv_count)
}
