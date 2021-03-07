package com.demo.demoapplication.room

import androidx.room.*

@Dao
interface StoreDao {

    @Insert
    suspend fun addStore(storeEntity: StoreEntity)

    @Query("SELECT * FROM StoreEntity ORDER BY id DESC")
    suspend fun getAllStores(): List<StoreEntity>

//    @Insert
//    suspend fun addMultipleAcronyms(vararg acronymEntity: AcronymEntity)

    @Update
    suspend fun updateStore(storeEntity: StoreEntity)

    @Delete
    suspend fun deleteStore(storeEntity: StoreEntity)
}