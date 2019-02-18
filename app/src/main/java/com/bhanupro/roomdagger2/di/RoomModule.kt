package com.bhanupro.roomdagger2.di

import android.app.Application
import androidx.room.Room
import com.bhanupro.roomdagger2.data.ProductDao
import com.bhanupro.roomdagger2.repository.AppDatabase
import com.bhanupro.roomdagger2.repository.ProductDataSource
import com.bhanupro.roomdagger2.repository.ProductRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(application: Application) {

    private lateinit var appDb:AppDatabase

    init {
        appDb = Room.databaseBuilder(application,AppDatabase::class.java,"products.db").build()
    }

    @Singleton
    @Provides
    fun providesRoomDatabase():AppDatabase{
        return appDb
    }

    @Singleton
    @Provides
    fun providesProductDao(db:AppDatabase):ProductDao{
        return db.getProductDao()
    }

    @Singleton
    @Provides
    fun productRepository(dao:ProductDao):ProductRepository{
        return ProductDataSource(dao)
    }


}