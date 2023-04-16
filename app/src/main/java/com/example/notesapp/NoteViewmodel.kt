package com.example.notesapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

class NoteViewmodel(application: Application):AndroidViewModel(application) {
    val getAllNotes:LiveData<List<NoteEntity>>
    private val repository:NoteRepository

    init {
        val dao=NoteDatabase.getDatabase(application).getNoteDao()
         repository=NoteRepository(dao)
        getAllNotes=repository.allNotes
    }
    // we declare a variable scope that takes the scope of the viewModel and perform co routine actions
    val scope= MainScope()
    fun deleteNote(noteEntity: NoteEntity)= scope.launch(Dispatchers.IO) {
        repository.delte(noteEntity)
    }
    fun inserNote(noteEntity: NoteEntity)=scope.launch(Dispatchers.IO) {
        repository.insert(noteEntity)
    }
}
