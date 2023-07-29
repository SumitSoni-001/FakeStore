package com.example.fakestore.di

import android.app.Application

class FakeApplication : Application() {

    lateinit var fakeComponent: FakeComponent

    override fun onCreate() {
        super.onCreate()
        fakeComponent = DaggerFakeComponent.factory().create(this)
    }

}