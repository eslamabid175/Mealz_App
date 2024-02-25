package com.eslamaped.mealzapp.model

import com.eslamaped.mealzapp.model.api.MealsWebServise
import com.eslamaped.mealzapp.model.response.MealCategoriesResponses
import com.eslamaped.mealzapp.model.response.MealResponce
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MealsRepository (private val webServise: MealsWebServise=MealsWebServise()){

    private var catchMeal= listOf<MealResponce>()

suspend fun getMeals():MealCategoriesResponses
{
    val responce=webServise.getMeals()
    catchMeal=responce.categories
    return responce
    //webServise.getMeals().execute().body()
}
fun getMeal(id:String):MealResponce?{
    return catchMeal.firstOrNull(){it.id==id}
}
companion object{
    private var instance:MealsRepository?=null


    fun getInstance()= instance?: synchronized(this){ instance?:MealsRepository().also  { instance=it }}
}
}