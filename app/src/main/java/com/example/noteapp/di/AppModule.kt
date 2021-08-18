package com.example.noteapp.di

import android.app.Application
import com.example.noteapp.database.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) = NoteDatabase.getInstance(application)

    @Singleton
    @Provides
    fun provideNoteDao(database: NoteDatabase) = database.getNoteDao()


}