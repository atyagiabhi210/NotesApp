package com.example.notesapp

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {
    val allNotes: LiveData<List<NoteEntity>> = noteDao.getAllNotes()
    suspend fun insert(note:NoteEntity){
        noteDao.inserNote(note)
    }
    suspend fun delte(note: NoteEntity){
        noteDao.deleteNote(note)
    }
}