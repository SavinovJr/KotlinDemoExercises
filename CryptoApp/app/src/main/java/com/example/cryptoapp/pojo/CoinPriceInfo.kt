package com.example.cryptoapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cryptoapp.api.ApiFactory
import com.example.cryptoapp.utils.TimeUtils
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_price_list")
data class CoinPriceInfo(
    @SerializedName("TYPE")
    @Expose
    val type: String? = null,

    @SerializedName("MARKET")
    @Expose
    val market: String? = null,

    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String? = null,

    @SerializedName("FLAGS")
    @Expose
    val flags: String? = null,

    @SerializedName("PRICE")
    @Expose
    val price: String? = null,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Long? = null,

    @SerializedName("MEDIAN")
    @Expose
    val median: Double? = null,

    @SerializedName("LASTVOLUME")
    @Expose
    val lastVolume: Double? = null,

    @SerializedName("LASTVOLUMETO")
    @Expose
    val lastVolumeTo: Double? = null,

    @SerializedName("LASTTRADEID")
    @Expose
    val lastTradeId: String? = null,

    @SerializedName("VOLUMEDAY")
    @Expose
    val volumeDay: Double? = null,

    @SerializedName("VOLUMEDAYTO")
    @Expose
    val volumeDayTo: Double? = null,

    @SerializedName("VOLUME24HOUR")
    @Expose
    val volume24hour: Double? = null,

    @SerializedName("VOLUME24HOURTO")
    @Expose
    val volume24HourTo: Double? = null,

    @SerializedName("OPENDAY")
    @Expose
    val openDay: Double? = null,

    @SerializedName("HIGHDAY")
    @Expose
    val highDay: Double? = null,

    @SerializedName("LOWDAY")
    @Expose
    val lowDay: Double? = null,

    @SerializedName("OPEN24HOUR")
    @Expose
    val open24hour: Double? = null,

    @SerializedName("HIGH24HOUR")
    @Expose
    val high24hour: Double? = null,

    @SerializedName("LOW24HOUR")
    @Expose
    val low24hour: Double? = null,

    @SerializedName("LASTMARKET")
    @Expose
    val lastMarket: String? = null,

    @SerializedName("VOLUMEHOUR")
    @Expose
    val volumeHour: Double? = null,

    @SerializedName("VOLUMEHOURTO")
    @Expose
    val volumeHourTo: Double? = null,

    @SerializedName("OPENHOUR")
    @Expose
    val openHour: Double? = null,

    @SerializedName("HIGHHOUR")
    @Expose
    val highHour: Double? = null,

    @SerializedName("LOWHOUR")
    @Expose
    val lowHour: Double? = null,

    @SerializedName("TOPTIERVOLUME24HOUR")
    @Expose
    val topTierVolume24hour: Double? = null,

    @SerializedName("TOPTIERVOLUME24HOURTO")
    @Expose
    val topTierVolume24HourTo: Double? = null,

    @SerializedName("CHANGE24HOUR")
    @Expose
    val change24hour: Double? = null,

    @SerializedName("CHANGEPCT24HOUR")
    @Expose
    val changePCT24hour: Double? = null,

    @SerializedName("CHANGEDAY")
    @Expose
    val changeDay: Double? = null,

    @SerializedName("CHANGEPCTDAY")
    @Expose
    val changePCTDay: Double? = null,

    @SerializedName("CHANGEHOUR")
    @Expose
    val changeHour: Double? = null,

    @SerializedName("CHANGEPCTHOUR")
    @Expose
    val changepcthour: Double? = null,

    @SerializedName("CONVERSIONTYPE")
    @Expose
    val conversionType: String? = null,

    @SerializedName("CONVERSIONSYMBOL")
    @Expose
    val conversionSymbol: String? = null,

    @SerializedName("SUPPLY")
    @Expose
    val supply: Int? = null,

    @SerializedName("MKTCAP")
    @Expose
    val mktcap: Double? = null,

    @SerializedName("MKTCAPPENALTY")
    @Expose
    val mktcappenalty: Int? = null,

    @SerializedName("CIRCULATINGSUPPLY")
    @Expose
    val circulatingsupply: Int? = null,

    @SerializedName("CIRCULATINGSUPPLYMKTCAP")
    @Expose
    val circulatingsupplymktcap: Double? = null,

    @SerializedName("TOTALVOLUME24H")
    @Expose
    val totalvolume24h: Double? = null,

    @SerializedName("TOTALVOLUME24HTO")
    @Expose
    val totalvolume24hto: Double? = null,

    @SerializedName("TOTALTOPTIERVOLUME24H")
    @Expose
    val totaltoptiervolume24h: Double? = null,

    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    @Expose
    val totaltoptiervolume24hto: Double? = null,

    @SerializedName("IMAGEURL")
    @Expose
    val imageurl: String? = null
) {
    fun getFormattedTime(): String {
        return TimeUtils.convertTimestampToTime(lastUpdate)
    }

    fun getFullImageUrl(): String {
        return ApiFactory.BASE_IMAGE_URL + imageurl
    }
}