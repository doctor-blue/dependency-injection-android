package com.example.noteapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.model.Note

class NoteAdapter(
    private val context: Context,
    private val onClick: (Note) -> Unit,
    private val onDelete: (Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var notes: List<Note> = listOf()

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtTitle: TextView = itemView.findViewById(R.id.txt_item_title)
        private val txtDes: TextView = itemView.findViewById(R.id.txt_item_des)
        private val btnDelete: ImageView = itemView.findViewById(R.id.btn_delete_note)
        private val layoutItem: ConstraintLayout = itemView.findViewById(R.id.layout_item)

        fun onBind(note: Note) {
            txtDes.text = note.description
            txtTitle.text = note.title

            btnDelete.setOnClickListener { onDelete(note) }

            layoutItem.setOnClickListener { onClick(note) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(notes[position])
    }

    fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }
}