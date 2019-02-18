package com.bhanupro.roomdagger2.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bhanupro.roomdagger2.data.Product
import com.bhanupro.roomdagger2.data.ProductDao

@Database(entities = [Product::class],version = AppDatabase.version)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        const val version = 1
    }
    abstract fun getProductDao():ProductDao
}