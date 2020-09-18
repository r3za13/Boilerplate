package ir.r3za.data

import okhttp3.ResponseBody
import javax.inject.Inject

class NetworkDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getUsers(id: String): ResponseBody = apiService.getUsers(id)
}