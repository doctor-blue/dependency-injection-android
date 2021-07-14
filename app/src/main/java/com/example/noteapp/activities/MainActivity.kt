package com.example.noteapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.NoteApplication
import com.example.noteapp.R
import com.example.noteapp.adapter.NoteAdapter
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.di.DaggerAppComponent
import com.example.noteapp.model.Note
import com.example.noteapp.viewmodel.NoteViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val TAG = "NOTE_VIEW_MODEL"

    @Inject
    lateinit var noteViewModel: NoteViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        val appComponent = DaggerAppComponent.builder().application(application).build()
        val appComponent = (application as NoteApplication).appComponent
        appComponent.inject(this)

        Log.d(TAG, "MainActivity: ${noteViewModel.noteRepository} , $noteViewModel")

        initControls()
        initEvents()
    }

    private fun initEvents() {
        binding.btnOpenAddActivity.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initControls() {
        val adapter = NoteAdapter(this@MainActivity, onItemClick, onItemDelete)

        binding.rvNote.setHasFixedSize(true)
        binding.rvNote.layoutManager = LinearLayoutManager(this)
        binding.rvNote.adapter = adapter

        noteViewModel.getAllNote().observe(this, {
            adapter.setNotes(it)
        })

    }

    private val onItemClick: (Note) -> Unit = {
        val intent = Intent(this, UpdateNoteActivity::class.java)
        intent.putExtra("UPDATE_NOTE", it)
        startActivity(intent)

    }
    private val onItemDelete: (Note) -> Unit = {
        noteViewModel.deleteNote(it)
    }
}