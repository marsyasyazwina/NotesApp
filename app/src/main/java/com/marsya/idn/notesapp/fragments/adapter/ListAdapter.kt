package com.marsya.idn.notesapp.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.marsya.idn.notesapp.data.model.NoteData
import com.marsya.idn.notesapp.databinding.RowLayoutItemBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>(){
    var dataList = emptyList<NoteData>()
    class MyViewHolder(val  binding: RowLayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind (noteData: NoteData){
            binding.noteData = noteData
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup) : MyViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowLayoutItemBinding.inflate(layoutInflater, parent, false)
                return  MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder  = MyViewHolder.from(parent)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = dataList.size

    fun setData(noteData: List<NoteData>){
        val noteDifutil = NoteDifutil(dataList, noteData)
        val noteDiffResult = DiffUtil.calculateDiff(noteDifutil)
        this.dataList = noteData
        noteDiffResult.dispatchUpdatesTo(this)
    }
}