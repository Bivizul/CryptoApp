package com.bivizul.cryptoapp.domain.repository

import androidx.lifecycle.LiveData
import com.bivizul.cryptoapp.domain.model.CoinInfo

interface CoinRepository {

    fun getCoinInfoList(): LiveData<List<CoinInfo>>

    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo>

    fun loadData()
}