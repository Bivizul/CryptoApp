package com.bivizul.cryptoapp.domain.usecases

import com.bivizul.cryptoapp.domain.repository.CoinRepository

class GetCoinInfoListUseCase(
    private val repository: CoinRepository
) {

    operator fun invoke() = repository.getCoinInfoList()
}