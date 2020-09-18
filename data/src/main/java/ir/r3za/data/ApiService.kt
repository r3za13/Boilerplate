package ir.r3za.data

import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/users/{id}")
    suspend fun getUsers(@Path("id") userId: String): ResponseBody
}