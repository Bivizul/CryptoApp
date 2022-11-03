package com.bivizul.cryptoapp.domain.usecases

import com.bivizul.cryptoapp.domain.repository.CoinRepository

class GetCoinInfoUseCase(
    private val repository: CoinRepository
) {

    operator fun invoke(fromSymbol: String) = repository.getCoinInfo(fromSymbol)
}