package com.bivizul.cryptoapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bivizul.cryptoapp.R
import com.bivizul.cryptoapp.databinding.ItemCoinInfoBinding
import com.bivizul.cryptoapp.domain.CoinInfo
import com.squareup.picasso.Picasso

class CoinInfoAdapter(
    private val context: Context
) : ListAdapter<CoinInfo, CoinInfoViewHolder>(CoinInfoDiffCallback) {

    var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoinInfoViewHolder {
        val binding = ItemCoinInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CoinInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = getItem(position)
        with(holder.binding) {
            with(coin) {
                val symbolTemplate = context.getString(R.string.symbols_template)
                val lastUpdateTemplate = context.getString(R.string.last_update_template)
                tvSymbols.text = String.format(symbolTemplate, fromSymbol, toSymbol)
                tvPrice.text = price
                tvLastUpdate.text = String.format(lastUpdateTemplate, lastUpdate)
                Picasso.get().load(imageUrl).into(ivLogoCoin)
                root.setOnClickListener {
                    onCoinClickListener?.onCoinClick(this)
                }
            }
        }
    }

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinInfo)
    }


}