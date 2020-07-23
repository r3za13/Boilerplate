package ir.r3za.data

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("test")
    suspend fun getUsers(): Response<ResponseBody>
}