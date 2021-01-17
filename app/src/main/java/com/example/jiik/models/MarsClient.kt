package com.example.jiik.models

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object MarsClient{
    const val BASE_URL = "https://mars.udacity.com/"
    fun getClient():Constants
    {
        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        val retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(BASE_URL)
                .build()

        val retrofitService: Constants by lazy {
            retrofit.create(Constants::class.java)
        }
        return retrofitService
    }
}