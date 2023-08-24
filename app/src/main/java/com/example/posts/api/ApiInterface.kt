package com.example.posts.api

import com.example.posts.models.Posts
import com.example.posts.models.PostsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/products")
    suspend fun getProducts(): Response<PostsResponse>

    @GET("/products{id}")
    suspend fun getProducts(@Path("id")productId:Int): Response<Posts>

}