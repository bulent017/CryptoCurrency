package com.example.cryptocurrencyapp.common
/*
 Kotlin'de, sealed class genellikle belirli bir sayıda alt sınıfa sahip bir üst sınıf oluşturmak için kullanılır.
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null){
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data,message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}
