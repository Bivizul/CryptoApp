package com.bivizul.cryptoapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bivizul.cryptoapp.utils.convertTimestampToTime

@Entity(tableName = "full_price_list")
data class CoinPriceInfo(
    @SerializedName("TYPE")
    @Expose
    val type: String?,
    @SerializedName("MARKET")
    @Expose
    val market: String?,
    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String?,
    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String?,
    @SerializedName("FLAGS")
    @Expose
    val flags: String?,
    @SerializedName("PRICE")
    @Expose
    val price: String?,
    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Long?,
    @SerializedName("LASTVOLUME")
    @Expose
    val lastVolume: String?,


    @SerializedName("TOTALVOLUME24H")
    @Expose
    val totalVolume24Hour: String?,
    @SerializedName("TOTALVOLUME24HTO")
    @Expose
    val totalVolume24HourTo: String?,
    @SerializedName("TOTALTOPTIERVOLUME24H")
    @Expose
    val totalTopTierVolume24Hour: String?,
    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    @Expose
    val totalTopTierVolume24HourTo: String?,
    @SerializedName("IMAGEURL")
    @Expose
    val imageUrl: String?,
) {
    fun getFormattedTime(): String {
        return convertTimestampToTime(lastUpdate)
    }

    fun getFullImageUrl(): String {
        return BASE_IMAGE_URL + imageUrl
    }
}