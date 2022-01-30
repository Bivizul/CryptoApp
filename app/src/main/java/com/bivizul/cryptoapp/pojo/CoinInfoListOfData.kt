package com.bivizul.cryptoapp.pojo

data class CoinInfoListOfData(
    @SerializedName("Data")
    @Expose
    val data: List<Datum>? = null
)