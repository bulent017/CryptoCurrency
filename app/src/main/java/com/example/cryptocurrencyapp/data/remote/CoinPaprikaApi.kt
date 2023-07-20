package com.example.cryptocurrencyapp.data.remote

import com.example.cryptocurrencyapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto> // suspend fonksiyonlar coroutinler ile çalışmaya izin verir

    @GET("/v1/coins{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId : String)




}