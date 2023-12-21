package com.example.veggiehealth.data.remote.response

import com.google.gson.annotations.SerializedName

data class DetailVegetableResponse(

	@field:SerializedName("vegetable")
	val vegetable: Vegetable,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Boolean,


)

data class Vegetable(

	@field:SerializedName("benefits")
	val benefits: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("vitamins")
	val vitamins: String? = null,

	@field:SerializedName("carbs")
	val carbs: String? = null,

	@field:SerializedName("protein")
	val protein: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("calories")
	val calories: String? = null
)
