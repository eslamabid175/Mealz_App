package com.eslamaped.mealzapp.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eslamaped.mealzapp.model.response.MealResponce

@Composable
fun MealDetaleidSc(meal: MealResponce?) {

var profilePictureStatee by remember {
    mutableStateOf(MealProfilePictureState.Normal)
}
    val transistion= updateTransition(targetState = profilePictureStatee,label = "")
//    var isExpanded by remember {
//        mutableStateOf(false)
//    }
    val imgeSizeDp by transistion.animateDp(targetValueByState = { it.size }, label = "")
    val color by transistion.animateColor(targetValueByState = { it.color }, label = "")
    val borderwidthsize by transistion.animateDp(targetValueByState = { it.borderWidth }, label = "")


    Column {
        Row {
            Card(
                modifier = Modifier.padding(16.dp),
                shape = CircleShape,
                border = BorderStroke(width = borderwidthsize, color = color)
            ) {
                AsyncImage(
                    model = meal?.imageurl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(imgeSizeDp)
                        .padding(8.dp)
                )
            }
            Text(
                text = meal?.name ?: "defult Name",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Button(
            modifier = Modifier.padding(16.dp),
            onClick = { profilePictureStatee=if(profilePictureStatee==MealProfilePictureState.Normal) MealProfilePictureState.Expanded
                      else MealProfilePictureState.Normal
                      },
        ) {
            Text("Change The State Of Image")
        }
    }

}

enum class MealProfilePictureState(val color: Color,val size :Dp,val borderWidth:Dp){

    Normal(Color.Magenta,120.dp,8.dp),
    Expanded(Color.Green,220.dp,20.dp)

}