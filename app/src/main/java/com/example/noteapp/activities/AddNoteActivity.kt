package com.example.noteapp.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.noteapp.R
import com.example.noteapp.databinding.ActivityAddNoteBinding
import com.example.noteapp.model.Note
import com.example.noteapp.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteActivity : AppCompatActivity() {
    private val TAG = "NOTE_VIEW_MODEL"

    private val noteViewModel: NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityAddNoteBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_add_note)

        Log.d(TAG, "AddNoteActivity: ${noteViewModel.noteRepository} , $noteViewModel")

        binding.btnAdd.setOnClickListener {
            val note =
                Note(binding.edtNoteTitle.text.toString(), binding.edtNoteDes.text.toString())
            noteViewModel.insertNote(note)
            finish()
        }

    }
}