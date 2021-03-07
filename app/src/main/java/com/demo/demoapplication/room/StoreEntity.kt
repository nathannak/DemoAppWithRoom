package com.demo.demoapplication.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.demo.demoapplication.model.Location

@Entity
class StoreEntity(val storeKey: String, val storeData: Location)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}