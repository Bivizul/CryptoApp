package com.bivizul.cryptoapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.bivizul.cryptoapp.data.repository.CoinRepositoryImpl
import com.bivizul.cryptoapp.domain.usecases.GetCoinInfoListUseCase
import com.bivizul.cryptoapp.domain.usecases.GetCoinInfoUseCase
import com.bivizul.cryptoapp.domain.usecases.LoadDataUseCase

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)


    init {
        loadDataUseCase()
    }

}