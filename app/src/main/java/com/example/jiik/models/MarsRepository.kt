package com.example.jiik.models

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarsRepository (val application: Application) {
    val showProgress = MutableLiveData<Boolean>()
    val marsData = MutableLiveData<List<MarsVariables>>()

    fun getMarsData() {
        showProgress.value = true

        val retrofitService = MarsClient.getClient()
        val callApi = retrofitService.getMarsData()


        callApi.enqueue(object : Callback<List<MarsVariables>> {
            override fun onFailure(call: Call<List<MarsVariables>>, t: Throwable) {

                showProgress.value = false
                Toast.makeText(application, "Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                    call: Call<List<MarsVariables>>,
                    response: Response<List<MarsVariables>>
            ) {
                showProgress.value = false
                val marsDataList = response.body()
                marsData.value = marsDataList
            }
        })
    }
}