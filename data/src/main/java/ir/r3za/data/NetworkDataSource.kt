package ir.r3za.data

import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class NetworkDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getUsers(): Response<ResponseBody> = apiService.getUsers()
}