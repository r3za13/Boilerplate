package ir.r3za

import android.util.Log
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.IOException

open class BaseRepository {
    suspend fun <T : Any> apiCall(
        call: suspend () -> Response<T>
    ): ApiResponse<T> {
        try {
            val response = call.invoke()
            if (response.isSuccessful) {
                return ApiResponse.Success(response.body())
            }
            return ApiResponse.Error(
                IOException(
                    parseError(response.errorBody()) ?: "Unknown Error!"
                )
            )
        } catch (exception: IOException) {
            return ApiResponse.Error(exception)
        }
    }

    private fun parseError(errorBody: ResponseBody?): String? {
        return "error"
    }
}