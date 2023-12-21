package com.example.veggiehealth.data.remote.response

import com.google.gson.annotations.SerializedName

data class PredictionResponse(

	@field:SerializedName("prediction")
	val prediction: String,

	@field:SerializedName("accuracy")
	val accuracy: Any,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("vegetableDetail")
	val vegetableDetail: VegetableDetail,

	@field:SerializedName("status")
	val status: Boolean,

	@field:SerializedName("vegetableId")
	val vegetableId: Int
)

data class VegetableDetail(

	@field:SerializedName("benefits")
	val benefits: String,

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("vitamins")
	val vitamins: String,

	@field:SerializedName("carbs")
	val carbs: String,

	@field:SerializedName("protein")
	val protein: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("calories")
	val calories: String
)
