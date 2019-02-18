package com.bhanupro.roomdagger2

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bhanupro.roomdagger2.data.Product
import com.bhanupro.roomdagger2.di.AppModule
import com.bhanupro.roomdagger2.di.DaggerAppComponent
import com.bhanupro.roomdagger2.di.RoomModule
import com.bhanupro.roomdagger2.repository.ProductDataSource
import com.bhanupro.roomdagger2.repository.ProductRepository
import java.util.*

import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var productRepository:ProductRepository
    @Inject
    lateinit var productDataSource: ProductDataSource
    private var totalCount:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .roomModule(RoomModule(application))
            .build()
            .inject(this)

        productRepository.findAll().observeForever {
            totalCount = it.size
            Toast.makeText(this@MainActivity,"product size is ${it.size}",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()
        AsyncTask.execute {
            productDataSource.insert(Product(totalCount+1,"Title is","dscription is"))
        }

    }
}
