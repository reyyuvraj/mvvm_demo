package com.example.jiik.models

import retrofit2.Call
import retrofit2.http.GET

interface Constants {
    @GET("realestate")
    fun getMarsData(): Call<List<MarsVariables>>
}

