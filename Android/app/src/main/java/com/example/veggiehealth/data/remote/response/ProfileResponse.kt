package com.example.veggiehealth.data.remote.response

import com.google.gson.annotations.SerializedName

data class ProfileResponse(

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("userProfile")
	val userProfile: UserProfile,

	@field:SerializedName("status")
	val status: Boolean
)

data class UserProfile(

	@field:SerializedName("emailProfile")
	val emailProfile: String,

	@field:SerializedName("userProfile")
	val userProfile: String
)
