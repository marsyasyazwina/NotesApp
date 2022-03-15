package com.marsya.idn.notesapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "todot_table")
@Parcelize
class NoteData (
    @PrimaryKey(autoGenerate = true)

    val id: Int,
    val tittle : String,
    val priority: Priority,
    val description: String,
) : Parcelable