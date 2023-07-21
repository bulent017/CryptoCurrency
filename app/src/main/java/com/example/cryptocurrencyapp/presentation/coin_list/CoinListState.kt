package com.example.cryptocurrencyapp.presentation.coin_list

import com.example.cryptocurrencyapp.domain.repository.model.Coin

data class CoinListState(
    val isLodading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String =""
)
