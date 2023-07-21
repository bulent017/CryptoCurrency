package com.example.cryptocurrencyapp.data.repository

import com.example.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.example.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyapp.data.remote.dto.CoinDto
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImplmentation @Inject constructor( //Bu kod parçası, Kotlin'de bir sınıf tanımıdır. Sınıfın adı CoinRepositoryImplementation ve bu sınıf, CoinRepository adlı bir arayüzü uygulamaktadır (: CoinRepository kısmı bu uygulamayı ifade eder). Bu arayüzün kendisi, sınıfın hangi işlevleri sağlaması gerektiğini tanımlar.
    private  val api : CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
        }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
        }

}

/*
CoinRepositoryImplementation sınıfı, CoinRepository arayüzünü uygulayan bir sınıftır.
Bu sınıf, CoinRepository arayüzünde tanımlanan işlevleri gerçekleştirir ve bu işlevlerin
 nasıl çalıştığını belirtir. Bu durumda, CoinRepositoryImplementation sınıfı, CoinPaprikaApi'yi
 kullanarak bu işlevleri gerçekleştirir.

CoinRepositoryImplementation sınıfı şu şekilde anlaşılabilir:

@Inject constructor(private val api: CoinPaprikaApi) ifadesi,
CoinRepositoryImplementation sınıfının bir örneğinin oluşturulmasında
Dagger Hilt tarafından kullanılan bir enjeksiyon yapılandırıcısıdır.
 Bu, Dagger Hilt'in CoinPaprikaApi'nin bir örneğini otomatik olarak CoinRepositoryImplementation
  sınıfına enjekte etmesini sağlar. Bu, CoinRepositoryImplementation
  sınıfının CoinPaprikaApi'ye erişmesini ve API isteklerini yapmasını sağlar.

override suspend fun getCoins(): List<CoinDto> işlevi, CoinRepository
arayüzünde tanımlanan getCoins işlevini uygular. Bu işlev, CoinPaprikaApi'nin getCoins
 işlevini çağırır ve bu işlevin sonucunu döndürür. Bu, bir API isteğini
  gerçekleştirir ve bu isteğin sonucunda elde edilen CoinDto listesini döndürür.

override suspend fun getCoinById(coinId: String): CoinDetailDto işlevi,
 CoinRepository arayüzünde tanımlanan getCoinById işlevini uygular. Bu işlev,
  CoinPaprikaApi'nin getCoinById işlevini çağırır ve bu işlevin sonucunu döndürür.
  Bu, bir API isteğini gerçekleştirir ve bu isteğin sonucunda elde edilen CoinDetailDto
   nesnesini döndürür.

Bu şekilde, CoinRepositoryImplementation sınıfı, CoinRepository arayüzünü uygular ve bu arayüzde tanımlanan işlevleri CoinPaprikaApi kullanarak gerçekleştirir. Bu, bir tür Dependency Injection örneğidir, yani CoinRepositoryImplementation sınıfı, CoinPaprikaApi'ye bağımlılık olarak dışarıdan bir CoinPaprikaApi nesnesi alır ve bu nesnenin sağladığı işlevleri kullanır.
 */