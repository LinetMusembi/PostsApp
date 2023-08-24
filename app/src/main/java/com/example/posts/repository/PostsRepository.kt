package com.example.posts.repository

import com.example.posts.api.ApiClient
import com.example.posts.api.ApiInterface
import com.example.posts.models.PostsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class PostsRepository {
    val apiClient =ApiClient.buildClient(ApiInterface::class.java)
    suspend fun getPosts():Response<PostsResponse>{
        return withContext(Dispatchers.IO){
            apiClient.getPosts()
        }

    }

}

