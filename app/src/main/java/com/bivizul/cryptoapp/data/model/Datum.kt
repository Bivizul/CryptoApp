package com.bivizul.cryptoapp.data.model

data class Datum(
    @SerializedName("COinInfo")
    @Expose
    val coinInfo: CoinInfo? = null
)