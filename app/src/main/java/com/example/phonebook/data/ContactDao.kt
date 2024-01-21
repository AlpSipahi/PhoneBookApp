package com.example.phonebook.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
@Dao
interface ContactDao {

    @Query("SELECT * from contacts ORDER BY name ASC")
    fun getAllItems(): Flow<List<Contact>>

    @Query("SELECT * from contacts WHERE id = :id")
    fun getItem(id: Int): Flow<Contact>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Contact)

    @Update
    suspend fun update(item: Contact)

    @Delete
    suspend fun delete(item: Contact)
}
