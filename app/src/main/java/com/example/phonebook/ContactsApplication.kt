package com.example.phonebook

import android.app.Application
import com.example.phonebook.data.AppContainer
import com.example.phonebook.data.AppDataContainer

class ContactsApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
