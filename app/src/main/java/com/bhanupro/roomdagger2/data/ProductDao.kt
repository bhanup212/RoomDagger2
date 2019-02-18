package com.bhanupro.roomdagger2.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDao {

    @Query("SELECT * FROM product WHERE id=:id")
    fun findById(id:Int):LiveData<Product>

    @Query("SELECT * FROM product")
    fun findAll():LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product: Product):Long

    @Delete
    fun delete(product: Product):Int
}