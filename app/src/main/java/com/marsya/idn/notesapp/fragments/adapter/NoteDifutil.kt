package com.marsya.idn.notesapp.fragments.adapter

import androidx.recyclerview.widget.DiffUtil
import com.marsya.idn.notesapp.data.model.NoteData

class NoteDifutil (
    private val  oldList: List<NoteData>,
    private val newList: List<NoteData>,
        ): DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
                && oldList[oldItemPosition].tittle == newList[newItemPosition].tittle
                && oldList[oldItemPosition].description == newList[newItemPosition].description
                && oldList[oldItemPosition].priority == newList[newItemPosition].priority
    }
}