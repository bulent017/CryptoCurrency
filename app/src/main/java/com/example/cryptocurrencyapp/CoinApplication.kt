package com.example.cryptocurrencyapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/*
(CoinApplication )bu sınıf genellikle dependency injection framework'lerini başlatmak için kullanılır.
 */

@HiltAndroidApp
class CoinApplication :Application(){
}