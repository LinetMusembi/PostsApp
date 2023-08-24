package com.example.posts.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/posts")
        .addConverterFactory(GsonConverterFactory.create()) //converts json to kotlin
        .build()
    fun <T> buildClient(apiInterface:Class<T>):T{
        return retrofit.create(apiInterface)
    }
}