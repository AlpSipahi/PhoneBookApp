package com.example.phonebook.data

import kotlinx.coroutines.flow.Flow

class OfflineContactsRepository(private val contactDao: ContactDao) : ContactsRepository {

    override fun getAllItemsStream(): Flow<List<Contact>> = contactDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Contact?> = contactDao.getItem(id)

    override suspend fun insertContact(item: Contact) = contactDao.insert(item)

    override suspend fun deleteContact(item: Contact) = contactDao.delete(item)

    override suspend fun updateContact(item: Contact) = contactDao.update(item)
}
