package com.bivizul.cryptoapp.pojo

import org.json.JSONObject

data class CoinPriceInfoRawData(
    @SerializedName("RAW")
    @Expose
    val coinPriceInfoJsonObject: JSONObject? = null
)