package com.example.cryptocurrencyapp.domain.use_case.get_coins

import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.dto.toCoin
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import com.example.cryptocurrencyapp.domain.repository.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository){

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {

        try {
            emit(Resource.Loading()) // emit() fonksiyonu, Kotlin'in Flow API'sinde kullanılır ve bir değeri Flow dışına göndermek için kullanılır. Flow, Kotlin'in coroutines kitaplığından gelen bir özellik olup, asenkron değerler serisini temsil eder.
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }
        catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An expected error occurred"))
        }
        catch (e: IOException){
            emit(Resource.Error( "Couldn't reach the server"))

        }
    }
}
/*
Flow  Kotlin'in Coroutine kütüphanesinde bulunan bir sınıftır.
Flow API, asenkron değerler dizisini temsil etmek için kullanılır ve
 çeşitli değerlerin bir dizi (stream) olarak asenkron bir şekilde elde edilmesini sağlar.
 */

/*
    operator anahtar kelimesi ->  bir sınıfın bir fonksiyon gibi çağrılabilmesini sağlar.
 */