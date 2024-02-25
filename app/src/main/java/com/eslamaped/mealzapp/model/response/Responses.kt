package com.eslamaped.mealzapp.model.response

import com.google.gson.annotations.SerializedName

//import com.google.gson.annotation.SerializedName
//Gson deserailezation:Json->data Classes
data class MealCategoriesResponses( val categories: List<MealResponce>)


//data calss MealsCartegoriesResponse(private val categories:List<Any>)

data class MealResponce(
  @SerializedName("idCategory")  val id: String,
  @SerializedName("strCategory")  val name: String,
  @SerializedName("strCategoryThumb")  val imageurl: String,
  @SerializedName("strCategoryDescription")  val description: String
)