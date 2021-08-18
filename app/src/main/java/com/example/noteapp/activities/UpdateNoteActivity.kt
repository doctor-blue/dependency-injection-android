package com.example.noteapp.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.noteapp.R
import com.example.noteapp.databinding.ActivityUpdateNoteBinding
import com.example.noteapp.model.Note
import com.example.noteapp.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateNoteActivity : AppCompatActivity() {
    private val TAG = "NOTE_VIEW_MODEL"

    private val noteViewModel: NoteViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityUpdateNoteBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_update_note)

        Log.d(TAG, "UpdateNoteActivity: ${noteViewModel.noteRepository} , $noteViewModel")

        val note = intent.getSerializableExtra("UPDATE_NOTE") as Note

        binding.edtNoteTitle.setText(note.title)
        binding.edtNoteDes.setText(note.description)

        binding.btnUpdate.setOnClickListener {
            note.title = binding.edtNoteTitle.text.toString()
            note.description = binding.edtNoteDes.text.toString()
            noteViewModel.updateNote(note)
            finish()
        }

    }
}