package com.myproject.chap8

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.myproject.chap8.databinding.RvItemBinding
import com.myproject.chap8.model.Data

class MainAdapter: PagingDataAdapter<Data, MainAdapter.ViewHolder>(callback) {
    companion object{
        private val callback = object : DiffUtil.ItemCallback<Data>(){
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class ViewHolder(binding: RvItemBinding): RecyclerView.ViewHolder(binding.root){
        val img = binding.imgArea
        val text = binding.textArea

        fun bind(item: Data){
            text.text = item._id
            img.load(item.airline[0].logo)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }
}