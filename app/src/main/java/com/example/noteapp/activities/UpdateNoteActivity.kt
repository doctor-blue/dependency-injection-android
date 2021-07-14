package com.example.noteapp.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.NoteApplication
import com.example.noteapp.R
import com.example.noteapp.databinding.ActivityUpdateNoteBinding
import com.example.noteapp.di.DaggerAppComponent
import com.example.noteapp.model.Note
import com.example.noteapp.viewmodel.NoteViewModel
import javax.inject.Inject

class UpdateNoteActivity : AppCompatActivity() {
    private val TAG = "NOTE_VIEW_MODEL"

    @Inject
    lateinit var noteViewModel: NoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityUpdateNoteBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_update_note)

//        val appComponent = DaggerAppComponent.builder().application(application).build()

        val appComponent = (application as NoteApplication).appComponent
        appComponent.inject(this)



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