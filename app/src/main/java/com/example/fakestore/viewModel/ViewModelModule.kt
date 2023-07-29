package com.example.fakestore.viewModel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @ClassKey(FakeViewModel::class)
    @IntoMap
    abstract fun getFakeViewModel(@BindsInstance fakeViewModel: FakeViewModel) : ViewModel

    @Binds
    @ClassKey(ViewModelExtra::class)
    @IntoMap
    abstract fun getViewModelExtra(@BindsInstance viewModelExtra: ViewModelExtra) : ViewModel

}