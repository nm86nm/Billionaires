package com.mnp.billionaires.domain.use_case.get_bilionaires

import android.content.Context
import com.mnp.billionaires.common.Resource
import com.mnp.billionaires.data.remote.dto.toBillionaire
import com.mnp.billionaires.domain.model.Billionaire
import com.mnp.billionaires.domain.repository.BillionaireRepository
import com.mnp.billionaires.presentation.check_internet_connection.NetworkStatus
import com.mnp.billionaires.presentation.check_internet_connection.ObserverConnection
import com.mnp.billionaires.presentation.MainActivity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBillionairesUseCase @Inject constructor(
    private val billionaireRepository: BillionaireRepository
) {
    operator fun invoke(): Flow<Resource<List<Billionaire>>> = flow {
        try {
            emit(Resource.Loading<List<Billionaire>>())
            val billionaires = billionaireRepository.getBillionaires().map { it.toBillionaire() }
            emit(Resource.Success<List<Billionaire>>(billionaires))
        } catch (e: HttpException){
            emit(Resource.Error<List<Billionaire>>("Something error occured: " + e.localizedMessage))
        } catch (e: IOException){
            emit(Resource.Error<List<Billionaire>>("Check internet connection."))
        }
    }
}