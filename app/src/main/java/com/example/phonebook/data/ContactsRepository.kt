package com.example.phonebook.data

import kotlinx.coroutines.flow.Flow

interface ContactsRepository {

    fun getAllItemsStream(): Flow<List<Contact>>

    fun getItemStream(id: Int): Flow<Contact?>

    suspend fun insertContact(item: Contact)

    suspend fun deleteContact(item: Contact)

    suspend fun updateContact(item: Contact)
}
