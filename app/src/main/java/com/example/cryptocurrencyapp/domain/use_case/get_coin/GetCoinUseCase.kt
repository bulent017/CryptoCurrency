package com.example.cryptocurrencyapp.domain.use_case.get_coin

import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import com.example.cryptocurrencyapp.domain.repository.model.CoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository){

    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {

        try {
            emit(Resource.Loading()) // emit() fonksiyonu, Kotlin'in Flow API'sinde kullanılır ve bir değeri Flow dışına göndermek için kullanılır. Flow, Kotlin'in coroutines kitaplığından gelen bir özellik olup, asenkron değerler serisini temsil eder.
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }
        catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An expected error occurred"))
        }
        catch (e: IOException){
            emit(Resource.Error( "Couldn't reach the server"))

        }
    }
}