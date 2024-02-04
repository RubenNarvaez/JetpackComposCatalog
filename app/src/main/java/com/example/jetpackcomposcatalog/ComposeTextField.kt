package com.example.jetpackcomposcatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
//STATE HOISTING
//This function receive 2 parameters, a "name" that is the text, and "onValueChanged" that
//recognize when the user change the state of the TextField
fun MyTextField(name:String,onValueChanged:(String)-> Unit) {
    Column(Modifier.fillMaxSize()) {

        //STATE HOISTING
        //The variable with mutableStateOf, has ti be outside of the composable view
        //So we can generate a function that allow us create the variable out of the composable
        // and use it in another place.
        //We create the variable on the main function.
        TextField(value = name, onValueChange = { onValueChanged(it) })
        //The Lambda function is make by the parent.

        //We have ti create a variable with remember an mutableStateOf to save the parameters when the view is loaded
        var myText by remember { mutableStateOf("Initial text:") }
        //We create a text field with initial value of "Initial text:" and it change when we write something
        TextField(value = myText, onValueChange = { myText = it })

        //ADVANCED TEXT FIELD
        var myTextLabel by remember { mutableStateOf("") }
        //We can add a label in our text field, that allows us help the user with a simple description of the text
        TextField(
            value = myTextLabel,
            onValueChange = { myTextLabel = it },
            label = { Text(text = "Introduce your Name") }
        )

        //Inside the TextField we have Lambdas functions, so we can program inside it
        var myTextLambdaLabel by remember { mutableStateOf("") }
        //We can add a label in our text field, that allows us help the user with a simple description of the text
        TextField(
            value = myTextLambdaLabel,
            onValueChange = {
                //In this case we going to put a conditions that allows block the letter "a"
                myTextLambdaLabel = if(it.contains("a")){
                    it.replace("a","")
                }else{it}},
            label = { Text(text = "No a allowed") }
        )

        //Another component that is equal than TextField with some visual differences is
        //Outlined text field, that have a color when is not selected and have a different
        //a different color when is selected
        var myOutlinedText by remember { mutableStateOf("") }

        OutlinedTextField(
            value = myOutlinedText,
            onValueChange = {myOutlinedText=it},
            modifier=Modifier.padding(25.dp),
            label = {Text("Outlined value")},
            colors = TextFieldDefaults.colors(

                focusedIndicatorColor = Color.Green,
                unfocusedIndicatorColor = Color.Red,

                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,

                focusedLabelColor = Color.Blue,
                unfocusedLabelColor = Color.Yellow
            )
        )
    }
}