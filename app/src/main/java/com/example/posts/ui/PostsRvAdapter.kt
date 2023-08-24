package com.example.posts.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.databinding.PostsListItemBinding
import com.example.posts.models.Posts

class PostsRvAdapter (var posts:List<Posts>): RecyclerView.Adapter<PostsRvAdapter.ProductsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding = PostsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostsRvAdapter.ProductsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val currentPost = posts.get(position)
        val binding = holder.binding
        binding.tvId.text = currentPost.it.toString()
        binding.tvUserId.text = currentPost.userId.toString()
        binding.tvBody.text = currentPost.body
        binding.tvTitle.text = currentPost.title
    }


    override fun getItemCount(): Int {
        return posts.size
    }

    class ProductsViewHolder(var binding: PostsListItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}