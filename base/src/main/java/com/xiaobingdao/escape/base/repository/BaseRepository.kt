package com.xiaobingdao.escape.base.repository

import com.xiaobingdao.escape.base.model.BaseResponse
import com.xiaobingdao.escape.base.model.NetworkResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import java.io.IOException

/**
 * Created by hs.ren
 */
open class BaseRepository {

    suspend fun <T : Any> apiCall(call: suspend () -> BaseResponse<T>): BaseResponse<T> {
        return call.invoke()
    }

    suspend fun <T : Any> safeApiCall(call: suspend () -> NetworkResult<T>, errorMessage: String): NetworkResult<T> {
        return try {
            call()
        } catch (e: Exception) {
            // An exception was thrown when calling the API so we're converting this to an IOException
            NetworkResult.Error(IOException(errorMessage, e))
        }
    }

    suspend fun <T : Any> executeResponse(response: BaseResponse<T>, successBlock: (suspend CoroutineScope.() -> Unit)? = null, errorBlock: (suspend CoroutineScope.() -> Unit)? = null): NetworkResult<T> {
        return coroutineScope {
            if (response.errorCode == -1) {
                errorBlock?.let { it() }
                NetworkResult.Error(IOException(response.errorMsg))
            } else {
                successBlock?.let { it() }
                NetworkResult.Success(response.data)
            }
        }
    }


}