package com.myproject.chap2

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.myproject.chap2.databinding.CatItemBinding

class CatListAdapter: ListAdapter<CatDataModel, CatListAdapter.ViewHolder>(DiffCallback){

    inner class ViewHolder(binding: CatItemBinding): RecyclerView.ViewHolder(binding.root){
        val catId = binding.catId
        val catName = binding.catName
        val catAge = binding.catAge

        fun bind(item: CatDataModel){
            catId.text = item.catId.toString()
            catName.text = item.catName
            catAge.text = item.catAge.toString()
        }
    }

    companion object{
        // List값이 기존 값과 같은지 다른지 !
        private val DiffCallback = object: DiffUtil.ItemCallback<CatDataModel>(){
            override fun areItemsTheSame(oldItem: CatDataModel, newItem: CatDataModel): Boolean {
                //고유값 비교
                return oldItem.catId == newItem.catId
            }

            override fun areContentsTheSame(oldItem: CatDataModel, newItem: CatDataModel): Boolean {
                // 내용 비교
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}