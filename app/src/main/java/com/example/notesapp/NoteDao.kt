package com.example.notesapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert
    fun inserNote(noteEntity: NoteEntity)
    @Delete
    fun deleteNote(noteEntity: NoteEntity)
    @Query("Select * from NoteEntity order by id ASC")
    fun getAllNotes(): LiveData<List<NoteEntity>>
}