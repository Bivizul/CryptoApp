package com.bivizul.cryptoapp.pojo

data class Datum(
    @SerializedName("COinInfo")
    @Expose
    val coinInfo: CoinInfo? = null
)