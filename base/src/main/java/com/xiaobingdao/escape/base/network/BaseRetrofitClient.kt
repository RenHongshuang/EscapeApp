package com.xiaobingdao.escape.base.network

import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.readystatesoftware.chuck.ChuckInterceptor
import com.xiaobingdao.escape.base.BuildConfig
import com.xiaobingdao.escape.base.utils.EscapeUtils
import com.xiaobingdao.escape.base.utils.NetWorkUtils
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by hs.ren
 */
abstract class BaseRetrofitClient {

    companion object {
        private const val TIME_OUT = 5
    }

    private val cookieJar by lazy { PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(EscapeUtils.applicationContext)) }

    private val client: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder()
            val logging = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                logging.level = HttpLoggingInterceptor.Level.BODY
            } else {
                logging.level = HttpLoggingInterceptor.Level.BASIC
            }

            builder.addInterceptor(logging)
                    .addInterceptor(ChuckInterceptor(EscapeUtils.applicationContext))
                    .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)

            handleBuilder(builder)

            return builder.build()
        }

    fun handleBuilder(builder: OkHttpClient.Builder) {

        val httpCacheDirectory = File(EscapeUtils.applicationContext.cacheDir, "responses")
        val cacheSize = 10 * 1024 * 1024L // 10 MiB
        val cache = Cache(httpCacheDirectory, cacheSize)
        builder.cache(cache)
                .cookieJar(cookieJar)
                .addInterceptor { chain ->
                    var request = chain.request()
                    if (!NetWorkUtils.isNetworkAvailable(EscapeUtils.applicationContext)) {
                        request = request.newBuilder()
                                .cacheControl(CacheControl.FORCE_CACHE)
                                .build()
                    }
                    val response = chain.proceed(request)
                    if (!NetWorkUtils.isNetworkAvailable(EscapeUtils.applicationContext)) {
                        val maxAge = 60 * 60
                        response.newBuilder()
                                .removeHeader("Pragma")
                                .header("Cache-Control", "public, max-age=$maxAge")
                                .build()
                    } else {
                        val maxStale = 60 * 60 * 24 * 28 // tolerate 4-weeks stale
                        response.newBuilder()
                                .removeHeader("Pragma")
                                .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                                .build()
                    }
                    response
                }
    }


    fun <S> getService(serviceClass: Class<S>, baseUrl: String): S {
        return Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
                .baseUrl(baseUrl)
                .build().create(serviceClass)
    }
}
