package com.demo.demoapplication.util

import androidx.room.TypeConverter
import com.demo.demoapplication.model.Location
import com.demo.demoapplication.model.Store
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.concurrent.locks.LockSupport

class Converters {

    @TypeConverter
    fun fromLocation(location: Location): String {
        return location.lat.toString().plus("|").plus(location.lng.toString())
    }

//    Json.encodeToString(value )

//    val listType = object : TypeToken<Store>() {}.type
//    return Gson().fromJson(value, listType)

    @TypeConverter
    fun toLocation(location: String) : Location {
        val list = location.split("|")
        return Location(list[0].toDouble(), list[1].toDouble())
    }

}

//alternatively: https://stackoverflow.com/questions/44736604/how-to-store-objects-in-android-room