package com.example.noteapp

import android.app.Application
import com.example.noteapp.di.AppComponent
import com.example.noteapp.di.DaggerAppComponent

class NoteApplication : Application() {

//    lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
//        appComponent = DaggerAppComponent.builder().application(this).build()
    }

}