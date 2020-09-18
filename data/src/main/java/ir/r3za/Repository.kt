package ir.r3za

import ir.r3za.data.NetworkDataSource
import javax.inject.Inject

class Repository @Inject constructor(private val networkDataSource: NetworkDataSource) {
    suspend fun getUsers(id: String): String =
        networkDataSource.getUsers(id).string()
}