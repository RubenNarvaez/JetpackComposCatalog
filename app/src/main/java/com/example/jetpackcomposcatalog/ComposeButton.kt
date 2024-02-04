package com.example.jetpackcomposcatalog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyComposableButton() {
    //STATE BUTTON
    var buttonState by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        //Inside the onClick we can put any program that we want
        Button(onClick = { }) {
            //Inside the button we can put any component that we want
            Text(text = "Crazy Button")
        }

        //We can personalize the button
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                /*backgroundColor*/ Color.Blue,
                contentColor = Color.Green
            ),
            border = BorderStroke(3.dp, Color.Green)
        ) {
            //Inside the button we can put any component that we want
            Text(text = "Crazy Button2")
        }

        //We can disable the button with the enable parameter in false.
        Button(
            onClick = { },
            enabled = false,
            colors = ButtonDefaults.buttonColors(
                /*backgroundColor*/ Color.Red,
                contentColor = Color.Magenta
            ),
            border = BorderStroke(3.dp, Color.Yellow)
        ) {
            //Inside the button we can put any component that we want
            Text(text = "Disable Button")
        }

        //As all components in compose we can add a state on the button.


        Button(
            //We save the state with the variable buttonState, it can be managed in the father,
            //but in this example we are going to program inside the MyComposableButton() fundtion
            onClick = { buttonState=false},
            enabled = buttonState) {
            //Inside the button we can put any component that we want
            Text(text = "Change State Button")
        }

        //OUTLINED BUTTON
        //Is the same thing but with other design
        OutlinedButton(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                /*backgroundColor*/ Color.Red,
                contentColor = Color.Magenta
            ),
        ) {
            //Inside the button we can put any component that we want
            Text(text = "OutlinedButton")
        }

        //TEXT BUTTON
        //The same, different design
        TextButton(onClick = {  }) {
            Text(text = "Clickable Text")
            
        }
    }
}
