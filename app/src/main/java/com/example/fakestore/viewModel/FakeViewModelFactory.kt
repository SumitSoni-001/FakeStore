package com.example.fakestore.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fakestore.repository.FakeRepository
import javax.inject.Inject

class FakeViewModelFactory @Inject constructor(private val map : Map<Class<*> , @JvmSuppressWildcards ViewModel>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return map[modelClass] as T
    }

}