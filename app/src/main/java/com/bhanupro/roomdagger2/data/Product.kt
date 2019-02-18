package com.bhanupro.roomdagger2.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Product(

    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title:String,
    var description:String
)