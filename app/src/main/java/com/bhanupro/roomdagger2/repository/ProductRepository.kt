package com.bhanupro.roomdagger2.repository

import androidx.lifecycle.LiveData
import com.bhanupro.roomdagger2.data.Product

interface ProductRepository {
    fun findById(id:Int):LiveData<Product>
    fun findAll():LiveData<List<Product>>
    fun insert(product: Product):Long
    fun delete(product: Product):Int
}