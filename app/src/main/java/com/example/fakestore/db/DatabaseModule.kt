package com.example.fakestore.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getFakerDb(context : Context) : FakerDb{
        return Room.databaseBuilder(context , FakerDb::class.java , "FakerDb").build()
    }

}