package com.bivizul.cryptoapp.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.bivizul.cryptoapp.domain.CoinInfo

object CoinInfoDiffCallback : DiffUtil.ItemCallback<CoinInfo>() {

    // сравниваем, один и тот же объект?
    override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    // смотрим на изменение содержимого
    override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem == newItem
    }
}