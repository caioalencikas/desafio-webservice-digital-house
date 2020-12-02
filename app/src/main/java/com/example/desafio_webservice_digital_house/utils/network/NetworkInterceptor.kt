package com.example.desafio_webservice_digital_house.utils.network


import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest

class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val ts = System.currentTimeMillis().toString()
        val apiKey = PUBLIC_KEY

        var request = chain.request()
        val originalHttpUrl = request.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(API_KEY, apiKey)
            .addQueryParameter(TS, ts)
            .addQueryParameter(HASH, getHash(ts))
            .build()

        val requestBuilder = request.newBuilder().url(url)
        request = requestBuilder.build()
        return chain.proceed(request)
    }

    private fun getHash(ts: String) = "$ts$PRIVATE_KEY$PUBLIC_KEY".md5

    private val String.md5: String
        get() {
            val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
            return bytes.joinToString("") {
                "%02x".format(it)
            }
        }

    companion object {
        private const val TS = "ts"
        private const val API_KEY = "apikey"
        private const val HASH = "hash"

        private const val PRIVATE_KEY = "ac6feeed7a4220efd12c709428d4afb36bdff2b1"
        const val PUBLIC_KEY = "2381a1811787e1f4fe657d0b159d8bb6"

        fun String.md5(): String {
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
        }
    }
}



