package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),INotesAdapter {
    private var _binding : ActivityMainBinding? = null
    lateinit var rvAdapter: NotesRVAdapter
    private val binding get() = _binding!!
    lateinit var viewmodel: NoteViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager:RecyclerView.LayoutManager=LinearLayoutManager(this)
        binding.recyclerView.layoutManager=layoutManager
        rvAdapter= NotesRVAdapter(this,this)
        binding.recyclerView.adapter=rvAdapter

        viewmodel=ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewmodel::class.java)
        viewmodel.getAllNotes.observe(this,
        Observer{list->
            list?.let {
                rvAdapter.updateList(it)
            }
        })


    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClicked(noteEntity: NoteEntity) {
        viewmodel.deleteNote(noteEntity)
        Toast.makeText(this,"${noteEntity.noteData.toString()}Deleted",Toast.LENGTH_LONG).show()
    }

    fun submitData(view: View) {
        val noteText=binding.input.text.toString()
        if(noteText.isNotEmpty()){
            viewmodel.inserNote(NoteEntity(noteText))
            Toast.makeText(this,"$noteText Deleted",Toast.LENGTH_LONG).show()

        }
    }
}