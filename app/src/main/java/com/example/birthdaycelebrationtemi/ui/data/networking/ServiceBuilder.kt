package com.example.birthdaycelebrationtemi.ui.data.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class ServiceBuilder {
    companion object {

        val myApi: APIService by lazy {
            return@lazy getRetrofit().create(APIService ::class.java)
        }
        @Volatile
        private var INSTANCE: Retrofit? = null

        private fun getRetrofit(): Retrofit {

            val temp = INSTANCE
            if (temp != null) {
                return temp
            }
            synchronized(this) {
                val instance = Retrofit.Builder()
                    .baseUrl("http://34.207.145.238:3031/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(OkHttpClient.Builder().build())
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}