package com.eslamaped.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.eslamaped.mealzapp.ui.details.MealDetailsViewModel
import com.eslamaped.mealzapp.ui.details.MealDetaleidSc
import com.eslamaped.mealzapp.ui.meals.MealsCatogriesScreen
import com.eslamaped.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // val viewModell by viewModels<MealsCategoryViewModel>()
            MealzAppTheme {
                // A surface container using the 'background' color from the theme

                FoodzApp()
            }
        }
    }
}


@Composable
private fun FoodzApp(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "destination_meals_list") {
        composable(route="destination_meals_list") {MealsCatogriesScreen{

            navigationMealId->navController.navigate("destination_meal_detail/$navigationMealId")
        } }

        // Add more destinations similarly.

    composable(route="destination_meal_detail/{meal_category_id}",
        arguments = listOf(navArgument("meal_category_id"){

            type= NavType.StringType
        })){

        val viewmodel:MealDetailsViewModel= viewModel()
MealDetaleidSc(viewmodel.mealState.value)
    }
}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MealzAppTheme {
        MealsCatogriesScreen(){}
    }
}