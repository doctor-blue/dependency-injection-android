package com.example.noteapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.R
import com.example.noteapp.model.Note
import com.example.noteapp.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_update_note.*

class UpdateNoteActivity : AppCompatActivity() {
    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProvider(
            this,
            NoteViewModel.NoteViewModelFactory(this.application)
        )[NoteViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_note)

        val note=intent.getSerializableExtra("UPDATE_NOTE") as Note
        edt_note_title.setText(note.title)
        edt_note_des.setText(note.description)

        btn_update.setOnClickListener {
            note.title=edt_note_title.text.toString()
            note.description=edt_note_des.text.toString()
            noteViewModel.updateNote(note)
            finish()
        }

    }
}