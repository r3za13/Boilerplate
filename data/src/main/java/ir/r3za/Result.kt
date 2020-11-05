package ir.r3za

sealed class ApiResponse<out T : Any> {
    data class Success<out T : Any>(val data: T?) : ApiResponse<T>()
    data class Error(val error: Exception) : ApiResponse<Nothing>()
}