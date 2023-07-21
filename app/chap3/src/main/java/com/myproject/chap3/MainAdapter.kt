package com.myproject.chap3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.myproject.chap3.databinding.NumberItemBinding
import com.myproject.chap3.db.entity.NumberEntity

class MainAdapter(private val list: ArrayList<NumberEntity>):
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    interface ItemClick{
        fun onClick(view: View, position: Int)
    }

    var updateClick: ItemClick? = null
    var deleteClick: ItemClick? = null

    inner class ViewHolder(binding: NumberItemBinding): RecyclerView.ViewHolder(binding.root){
        private val id = binding.id
        private val randomNum = binding.randomNum

        fun bind(item: NumberEntity){
            id.text = item.id.toString()
            randomNum.text = item.randomNumber

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NumberItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.findViewById<Button>(R.id.update).setOnClickListener {
            updateClick?.onClick(it, position)
        }

        holder.itemView.findViewById<Button>(R.id.delete).setOnClickListener {
            deleteClick ?.onClick(it, position)
        }
    }
}