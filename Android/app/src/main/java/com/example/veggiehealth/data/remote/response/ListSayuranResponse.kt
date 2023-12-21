package com.example.veggiehealth.data.remote.response

import com.google.gson.annotations.SerializedName

data class ListSayuranResponse(

	@field:SerializedName("vegetables")
	val vegetables: List<VegetablesItem>,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class VegetablesItem(

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
	val id: Int,

	@field:SerializedName("calories")
	val calories: String? = null
)
