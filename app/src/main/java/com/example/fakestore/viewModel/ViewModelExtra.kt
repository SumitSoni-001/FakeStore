package com.example.fakestore.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ViewModelExtra @Inject constructor(private val randomTask: RandomTask) : ViewModel() {
    init {
        randomTask.doTask()
    }
}

class RandomTask @Inject constructor() {
    fun doTask() {
        Log.d("task", "Random Task")
    }
}