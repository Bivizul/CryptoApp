package com.bivizul.cryptoapp.pojo

data class CoinInfo(
    @SerializedName("Name")
    @Expose
    val name: String? = null
)