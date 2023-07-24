package com.myproject.chap9.paging

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.myproject.chap9.data.Items

class GithubAdapter: PagingDataAdapter<Items, GithubViewHolder>(DIFF_CALLBACK) {

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Items>() {
            override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem == newItem
            }

        }

    }

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        val items = getItem(position)
        if (items != null) {
            holder.bind(items)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        return GithubViewHolder.create(parent)
    }
}