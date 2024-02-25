package com.eslamaped.mealzapp.ui.meals

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eslamaped.mealzapp.model.MealsRepository
import com.eslamaped.mealzapp.model.response.MealCategoriesResponses
import com.eslamaped.mealzapp.model.response.MealResponce
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoryViewModel(private val repository: MealsRepository=MealsRepository.getInstance()):ViewModel() {



init {
Log.d("Tag_Coroutines","Wer about to launch a coroutines")//1
  viewModelScope.launch(Dispatchers.IO) {
    Log.d("Tag_Coroutines","We have  launched a coroutines")//3

    val meals=getMeals()
    Log.d("Tag_Coroutines","We have  recived a coroutines")//4

    MealsState.value=meals
  }
  Log.d("Tag_Coroutines","otherwork")//2

}
  val MealsState: MutableState<List<MealResponce>> = mutableStateOf(emptyList<MealResponce>())


suspend fun getMeals():List<MealResponce> {
  return repository.getMeals().categories
}
}