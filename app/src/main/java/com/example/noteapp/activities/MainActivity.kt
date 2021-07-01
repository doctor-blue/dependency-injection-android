package com.example.noteapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.R
import com.example.noteapp.adapter.NoteAdapter
import com.example.noteapp.model.Note
import com.example.noteapp.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProvider(
            this,
            NoteViewModel.NoteViewModelFactory(this.application)
        )[NoteViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControls()
        initEvents()
    }

    private fun initEvents() {
        btn_open_add_activity.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initControls() {
        val adapter: NoteAdapter = NoteAdapter(this@MainActivity, onItemClick, onItemDelete)

        rv_note.setHasFixedSize(true)
        rv_note.layoutManager = LinearLayoutManager(this)
        rv_note.adapter = adapter

        noteViewModel.getAllNote().observe(this, Observer {
            adapter.setNotes(it)
        })

    }

    private val onItemClick: (Note) -> Unit = {
        val intent=Intent(this,UpdateNoteActivity::class.java)
        intent.putExtra("UPDATE_NOTE",it)
        startActivity(intent)

    }
    private val onItemDelete: (Note) -> Unit = {
        noteViewModel.deleteNote(it)
    }
}