package com.example.notesapp

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = arrayOf(NoteEntity::class), version = 1, exportSchema = false)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun getNoteDao():NoteDao
    //we have to make this Class a singleton as we don't want at run time that multiple instances of this
    //word database are created
    companion object{
        private var INSTANCE:NoteDatabase?=null
        fun getDatabase(context: Context):NoteDatabase{
            return INSTANCE?: synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE=instance
                //we return instance here
                instance

            }
        }

    }
}