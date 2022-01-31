package com.bivizul.cryptoapp.data.model

import org.json.JSONObject

data class CoinPriceInfoRawData(
    @SerializedName("RAW")
    @Expose
    val coinPriceInfoJsonObject: JSONObject? = null
)