package com.bivizul.cryptoapp.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bivizul.cryptoapp.data.network.ApiFactory
import com.bivizul.cryptoapp.data.database.AppDatabase
import com.bivizul.cryptoapp.data.model.CoinPriceInfo
import com.bivizul.cryptoapp.data.model.CoinPriceInfoRawData
import java.util.concurrent.TimeUnit

class CoinViewModel(application: Application): AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()

    val price = db.coinPriceInfoDao().getPriceList()

    fun getDetailInfo(fSym: String): LiveData<CoinPriceInfo> {
        return db.coinPriceInfoDao().getPriceInfoAboutCoin(fSym)
    }

    init{
        loadData()
    }

    private fun loadData(){
        val disposable = ApiFactory.apiService.getTopCoinsInfo(limit = 50)
            .map{it.data?.map{it.coinInfo?.name}?.joinToString(",")}
            .flatMap{ ApiFactory.apiService.getFullPriceList(fSyms = it)}
            .map{getPriceListFromRawData(it)}
            .delaySubscription(10, TimeUnit.SECONDS)
            .repeat()
            .retry()
            .subscribeOn(Schedulers.io())
            .subscribe({
                db.coinPriceInfoDao().insertPriceList(it)
                Log.d("TEST_OF_LOADONG_DATA", "Success: $it")
            },{
                Log.d("TEST_OF_LOADONG_DATA", "Failure: ${it.message}")
            })
        compositeDisposable.add(disposable)
    }

    private fun getPriceListFromRawData(
        coinPriceInfoRawData: CoinPriceInfoRawData
    ): List<CoinPriceInfo>{

    }

}