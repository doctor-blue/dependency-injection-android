package com.example.noteapp.database.repository

import androidx.lifecycle.LiveData
import com.example.noteapp.database.NoteDatabase
import com.example.noteapp.database.dao.NoteDao
import com.example.noteapp.model.Note
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepository @Inject constructor(noteDatabase: NoteDatabase) {

    private val noteDao: NoteDao = noteDatabase.getNoteDao()

    suspend fun insertNote(note:Note) = noteDao.insertNote(note)
    suspend fun updateNote(note:Note) = noteDao.updateNote(note)
    suspend fun deleteNote(note:Note) = noteDao.deleteNote(note)

    fun getAllNote():LiveData<List<Note>> = noteDao.getAllNote()

}