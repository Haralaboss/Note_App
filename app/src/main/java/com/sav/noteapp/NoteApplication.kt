package com.sav.noteapp

import android.app.Application
import com.sav.noteapp.repository.NoteRepository
import com.sav.noteapp.room.NoteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NoteApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())


    val database  by lazy{ NoteDatabase.getDatabase(this,applicationScope)}
    val repository by lazy {NoteRepository(database.getNoteDao())}

}