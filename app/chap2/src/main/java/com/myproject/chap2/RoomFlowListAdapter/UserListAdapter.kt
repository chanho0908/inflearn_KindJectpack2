package com.myproject.chap2.RoomFlowListAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.myproject.chap2.RoomFlowListAdapter.db.UserEntity
import com.myproject.chap2.databinding.UserItemBinding

class UserListAdapter: ListAdapter<UserEntity, UserListAdapter.ViewHolder>(callback) {

    companion object{
        private val callback = object : DiffUtil.ItemCallback<UserEntity>(){
            override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
                return oldItem == newItem
            }

        }
    }



    inner class ViewHolder(private val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(userEntity: UserEntity){
            binding.name.text = userEntity.name
            binding.age.text = userEntity.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}