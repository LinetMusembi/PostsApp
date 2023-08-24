package com.example.posts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posts.models.Posts
import com.example.posts.repository.PostsRepository
import kotlinx.coroutines.launch

class PostsViewModel: ViewModel() {
    val postsRepo=PostsRepository()
    var postsLiveData= MutableLiveData<List<Posts>>()
    var errorLiveData= MutableLiveData<String>()
    fun fetchPosts(){
        viewModelScope.launch {
            val response =postsRepo.getPosts()
            if(response.isSuccessful){
                val postsLists=response.body()?: emptyList()

                postsLiveData.postValue(postsLists)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}