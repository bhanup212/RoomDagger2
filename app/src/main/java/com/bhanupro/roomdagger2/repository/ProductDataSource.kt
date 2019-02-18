package com.bhanupro.roomdagger2.repository

import androidx.lifecycle.LiveData
import com.bhanupro.roomdagger2.data.Product
import com.bhanupro.roomdagger2.data.ProductDao
import javax.inject.Inject

class ProductDataSource @Inject constructor(dao:ProductDao): ProductRepository {

    private var productDao:ProductDao = dao

    override fun findById(id: Int): LiveData<Product> {
        return productDao.findById(id)
    }

    override fun findAll(): LiveData<List<Product>> {
        return productDao.findAll()
    }

    override fun insert(product: Product): Long {
        return productDao.insert(product)
    }

    override fun delete(product: Product): Int {
        return productDao.delete(product)
    }
}