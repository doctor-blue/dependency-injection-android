package com.example.noteapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp.database.dao.NoteDao
import com.example.noteapp.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object {
        @Volatile
        private var instance: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context, NoteDatabase::class.java, "NoteDatabase").build()
            }
            return instance!!
        }

    }

}