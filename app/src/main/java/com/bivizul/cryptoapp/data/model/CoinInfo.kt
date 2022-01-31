package com.bivizul.cryptoapp.data.model

data class CoinInfo(
    @SerializedName("Name")
    @Expose
    val name: String? = null
)