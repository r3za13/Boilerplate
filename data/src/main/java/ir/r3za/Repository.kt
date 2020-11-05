package ir.r3za

import ir.r3za.data.NetworkDataSource
import okhttp3.ResponseBody
import javax.inject.Inject

class Repository @Inject constructor(private val networkDataSource: NetworkDataSource) :
    BaseRepository() {
    suspend fun getUsers(id: String): ApiResponse<ResponseBody> = apiCall {
        networkDataSource.getUsers(id)
    }
}