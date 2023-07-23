package com.myproject.chap6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.myproject.chap6.databinding.ItemViewBinding

class MyAdapter: PagingDataAdapter<User, MyAdapter.ViewHolder>(diffCallback) {

    companion object{
        private val diffCallback = object: DiffUtil.ItemCallback<User>(){
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class ViewHolder(binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root){
        val id = binding.id
        val name = binding.userName

        fun bind(item: User){
            id.text = item.id.toString()
            name.text = item.userName
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }


}