package com.example.fakestore.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.fakestore.MainActivity
import com.example.fakestore.db.DatabaseModule
import com.example.fakestore.viewModel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class , DatabaseModule::class , ViewModelModule::class])
interface FakeComponent {

    fun inject(mainActivity: MainActivity)

    fun getMap() : Map<Class<*> , ViewModel>

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) : FakeComponent
    }

}