package com.bivizul.cryptoapp.domain.usecases

import com.bivizul.cryptoapp.domain.repository.CoinRepository

class LoadDataUseCase(
    private val repository: CoinRepository
) {

    operator fun invoke() = repository.loadData()
}