package com.example.noteapp.di

import android.app.Application
import com.example.noteapp.database.NoteDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) = NoteDatabase.getInstance(application)


}