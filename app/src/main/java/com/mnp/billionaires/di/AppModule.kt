package com.mnp.billionaires.di

import com.mnp.billionaires.data.remote.BillionaireApi
import com.mnp.billionaires.data.repository.BillionaireRepositoryImpl
import com.mnp.billionaires.domain.repository.BillionaireRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                    .build()
                chain.proceed(request)
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideBillionaireApi(okHttpClient: OkHttpClient): BillionaireApi{
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/nm86nm/json/main/billionaire/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BillionaireApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBillionaireRepository(api: BillionaireApi): BillionaireRepository{
        return BillionaireRepositoryImpl(api)
    }
}