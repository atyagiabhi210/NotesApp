package com.example.notesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.ItemNoteBinding

class NotesRVAdapter(val context: Context, val listener: MainActivity): RecyclerView.Adapter<NotesRVAdapter.NotesViewHolder>() {
    val allNotes=ArrayList<NoteEntity>()

    inner class NotesViewHolder(val binding: ItemNoteBinding):RecyclerView.ViewHolder(binding.root){
        val textView=binding.text
        val deleteButton=binding.deleteBtn

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val binding=ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        binding.deleteBtn.setOnClickListener {
            listener.onItemClicked(allNotes[NotesViewHolder(binding).adapterPosition])

        }
        return NotesViewHolder(binding)


    }

    override fun getItemCount(): Int {
        return allNotes.size

    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        with(holder){
            with(allNotes[position]){
                binding.text.text=this.noteData

            }
        }

    }
    fun updateList(newList:List<NoteEntity>){
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }
}
interface INotesAdapter{
    fun onItemClicked(noteEntity: NoteEntity)
}