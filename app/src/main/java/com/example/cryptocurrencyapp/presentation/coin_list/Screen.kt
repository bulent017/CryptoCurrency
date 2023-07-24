package com.example.cryptocurrencyapp.presentation.coin_list

sealed class Screen(val route: String){     // Ekranları yönetiyoruz
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_detail_screen")

}
