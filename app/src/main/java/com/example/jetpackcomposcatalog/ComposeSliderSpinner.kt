package com.example.jetpackcomposcatalog

import android.transition.Slide
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MyAdvanceSlider() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    //To save the entire value we create another variable
    var completeValue by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = {completeValue = sliderPosition.toInt().toString()},
            valueRange = 0f..10f,
            //Steps always count the first and last value so we have to subtract 2
            //We want 11 steps from 0 to 10 then we put 9 steps
            steps = 9
        )
        Text(text = completeValue)
    }
}


@Composable
fun MyBasicSlider() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}