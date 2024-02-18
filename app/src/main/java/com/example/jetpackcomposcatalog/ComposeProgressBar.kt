package com.example.jetpackcomposcatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun HelpFun() {
    MyComposableProgressBar()
}


@Composable
fun MyComposableProgressBar() {
    var showLoading by rememberSaveable{ mutableStateOf(false) }
    var progressStatus by rememberSaveable{ mutableStateOf(0.0f) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(48.dp)
            .fillMaxSize()
    ) {
        //We can use a circular progress bar o linear progress bar
        //If we don't put any modifier inside, this bars are going
        //To set as its default form.
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 8.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                trackColor = Color.Blue
            )
        }

        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Show/Hide")
        }

        CircularProgressIndicator(progress = progressStatus)
        Row (modifier = Modifier.fillMaxWidth()){
            Button(onClick = { progressStatus+=0.1f}) {
                Text(text = "Increment")
            }
            Button(onClick = {progressStatus-=0.1f}) {
                Text(text = "Decrement")
            }

        }

    }

}