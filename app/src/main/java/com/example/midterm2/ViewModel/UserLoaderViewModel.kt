package com.example.midterm2.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.midterm2.Data.RetrofitInstance
import com.example.midterm2.Data.UserApi
import com.example.midterm2.domain.User
import com.example.midterm2.domain.UserResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class UserLoaderViewModel: ViewModel() {
    private val list: MutableLiveData<List<User>> = MutableLiveData(listOf())
    private val api: UserApi = RetrofitInstance.api
    val userList: LiveData<List<User>> = list

    fun loadUsers() {
        viewModelScope.launch {
            list.postValue(mapToUser(api.getUsers()) ?: listOf())
        }
    }

    private fun mapToUser(users: Response<UserResponse>): List<User>? {
        return users.body()?.results

    }

}