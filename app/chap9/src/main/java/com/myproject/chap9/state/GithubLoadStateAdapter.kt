package com.myproject.chap9.state

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.myproject.chap9.databinding.LoadStateItemBinding

class GithubLoadStateAdapter(
    private val retry: () -> Unit
): LoadStateAdapter<GithubLoadStateViewHolder>() {

    override fun onBindViewHolder(holder: GithubLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): GithubLoadStateViewHolder {
        val binding = LoadStateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return GithubLoadStateViewHolder(binding, retry)
    }
}