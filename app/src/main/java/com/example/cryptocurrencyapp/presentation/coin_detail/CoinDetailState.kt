package com.example.cryptocurrencyapp.presentation.coin_detail

import com.example.cryptocurrencyapp.domain.repository.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String =""
)
