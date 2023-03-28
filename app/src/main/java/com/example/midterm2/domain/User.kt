package com.example.midterm2.domain

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("results")
    val results: List<User>
)

data class User (
    @SerializedName("name")
    val fullName: FullName?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("nat")
    val nationality: String?
        )

data class FullName (
    @SerializedName("first")
    val first: String?,
    @SerializedName("last")
    val last: String?
        )