package com.example.jetpackcomposcatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MyStateExample(){
    //I create the variable counter, but we can't modify the variable without a mutable State
    //var counter = 0
    //When we push the button all the view is going to recreate, so we have to remember the last value
    //var counter = mutableStateOf(0)
    //Now we create a bundle to have a space in memory with the value
    //var counter = remember {mutableStateOf(0)}
    //Now is working, until we rotate the device, because the screen is destroy and rebuild so we need a SaveAble State
    //var counter = rememberSaveAble() {mutableStateOf(0)}
    //Now is done, but we can optimize the operations with "by"
    var counter by rememberSaveable {mutableIntStateOf(0)}

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        Button(onClick = { /*counter+=1*/ counter+=1  }) {
            Text(text = "Pulsar")
        }
        // In this case we have to see inside the variable counter in the parameter value
        Text(text = "Number of clicks: $counter")

    }
}