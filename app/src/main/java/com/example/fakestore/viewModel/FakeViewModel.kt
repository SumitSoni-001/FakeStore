package com.example.fakestore.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.models.Products
import com.example.fakestore.repository.FakeRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class FakeViewModel @Inject constructor(private val fakeRepository: FakeRepository) : ViewModel() {
    val productsData: LiveData<List<Products>>
        get() = fakeRepository.products

    init {
        viewModelScope.launch {
            fakeRepository.getProducts()
        }
    }

}