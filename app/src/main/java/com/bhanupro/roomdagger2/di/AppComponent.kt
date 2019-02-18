package com.bhanupro.roomdagger2.di

import android.app.Application
import com.bhanupro.roomdagger2.MainActivity
import com.bhanupro.roomdagger2.data.ProductDao
import com.bhanupro.roomdagger2.repository.AppDatabase
import com.bhanupro.roomdagger2.repository.ProductRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [],modules = arrayOf(AppModule::class,RoomModule::class))
interface AppComponent {
    fun inject(activity: MainActivity)

    fun productDao():ProductDao
    fun appDatabase():AppDatabase
    fun productRepository():ProductRepository
    fun application():Application
}