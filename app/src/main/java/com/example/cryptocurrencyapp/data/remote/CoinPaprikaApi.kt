package com.example.cryptocurrencyapp.data.remote

import com.example.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto> // suspend fonksiyonlar coroutinler ile çalışmaya izin verir

    @GET("/v1/coins{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId : String) :CoinDetailDto //@Path anotasyonu, Retrofit kütüphanesinin bir parçasıdır ve HTTP isteklerinin URL'indeki değişken kısımları tanımlamak için kullanılır.




}