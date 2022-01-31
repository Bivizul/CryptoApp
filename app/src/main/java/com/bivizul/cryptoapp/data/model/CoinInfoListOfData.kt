package com.bivizul.cryptoapp.data.model

data class CoinInfoListOfData(
    @SerializedName("Data")
    @Expose
    val data: List<Datum>? = null
)