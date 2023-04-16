package com.example.notesapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class NoteEntity(//@ColumnInfo(name = "noteTitle")val noteTitle:String,
                 @ColumnInfo(name = "noteData")val noteData:String) {
    @PrimaryKey(autoGenerate = true)var id:Int=0

    
}