package com.example.jiik.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class MarsView (application: Application) : AndroidViewModel(application) {
    val showProgress: LiveData<Boolean>
    val marsData: LiveData<List<MarsVariables>>
    private val repository = MarsRepository(application)

    init {
        this.showProgress = repository.showProgress
        this.marsData = repository.marsData
    }

    fun getMarsData() {
        repository.getMarsData()
    }
}