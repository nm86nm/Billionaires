package com.mnp.billionaires.domain.use_case.get_billionaire

import com.mnp.billionaires.common.Resource
import com.mnp.billionaires.data.remote.dto.toBillionaire
import com.mnp.billionaires.data.remote.dto.toBillionaireDescription
import com.mnp.billionaires.domain.model.BillionaireDescription
import com.mnp.billionaires.domain.repository.BillionaireRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBillionaireUseCase @Inject constructor(
    private val billionaireRepository: BillionaireRepository
) {
    operator fun invoke(id: String): Flow<Resource<BillionaireDescription>> = flow {
        try {
            emit(Resource.Loading<BillionaireDescription>())
            val billionaire = billionaireRepository.getBillionaireById(id).toBillionaireDescription()
            emit(Resource.Success<BillionaireDescription>(billionaire))
        } catch (e: HttpException){
            emit(Resource.Error<BillionaireDescription>("HttpException: " + e.localizedMessage))
        } catch (e: IOException){
            emit(Resource.Error<BillionaireDescription>("IOException: " + e.localizedMessage))
        }
    }
}