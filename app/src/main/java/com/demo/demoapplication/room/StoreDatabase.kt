package com.demo.demoapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.demo.demoapplication.util.Converters

@Database(
    entities = arrayOf(StoreEntity::class),
    version = 1
)
@TypeConverters(Converters::class)
abstract class StoreDatabase: RoomDatabase() {

    abstract fun getStoreDao(): StoreDao

    companion object {
        @Volatile private var instance: StoreDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            StoreDatabase::class.java,
            "storedatabase"
        ).build()
    }
}