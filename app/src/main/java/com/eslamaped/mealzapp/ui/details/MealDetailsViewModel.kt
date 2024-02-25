package com.eslamaped.mealzapp.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.eslamaped.mealzapp.model.MealsRepository
import com.eslamaped.mealzapp.model.response.MealResponce

class MealDetailsViewModel(private val savedStateHandle:SavedStateHandle,
):ViewModel() {
                               private val repository:MealsRepository=MealsRepository.getInstance()

    var mealState= mutableStateOf<MealResponce?>(null)
init{
    val mealId=savedStateHandle.get<String>("meal_category_id")?:""
mealState.value=repository.getMeal(mealId)
}
}