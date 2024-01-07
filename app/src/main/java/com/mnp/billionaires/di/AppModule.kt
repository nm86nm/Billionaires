package com.mnp.billionaires.di

import com.mnp.billionaires.data.remote.BillionaireApi
import com.mnp.billionaires.data.repository.BillionaireRepositoryImpl
import com.mnp.billionaires.domain.repository.BillionaireRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBillionaireApi(): BillionaireApi{
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/nm86nm/json/main/billionaire/")
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