package com.example.jetpackcomposcatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposcatalog.ui.theme.CheckInfo

//Now we are going to make State hoisting with multiple RadioButton
@Composable
fun MyHoistingRadioButton(name: String , onItemSelected:(String) -> Unit) {
    //Here we don't use the state, so we are going to add it at OnCreate function
    Column(
        Modifier
              .fillMaxWidth()
            .background(Color.White)
    ) {
        Row() {
            //If I want to make work with more than 1 radioButton we have to do this code
            RadioButton(
                selected = name == "Text RadioButton",
                onClick = { onItemSelected("Text RadioButton") })
            Text(text = "Text RadioButton")
        }

        Row() {
            RadioButton(
                selected = name == "Text RadioButton2",
                onClick = {onItemSelected("Text RadioButton2")})
            Text(text = "Text RadioButton2")
        }

        Row() {
            RadioButton(
                selected = name == "Text RadioButton3",
                onClick = { onItemSelected("Text RadioButton3") })
            Text(text = "Text RadioButton3")
        }

        Row() {
            RadioButton(
                selected = name == "Text RadioButton4",
                onClick = {onItemSelected("Text RadioButton4")})
            Text(text = "Text RadioButton4")
        }

        Row() {
            RadioButton(
                selected = name == "Text RadioButton5",
                onClick = {onItemSelected("Text RadioButton5")})
            Text(text = "Text RadioButton5")
        }
    }
}



    //Now we are going to maka  a list of RadioButton
    @Composable
    fun MyRadioButtonList() {
        var selected by remember {
            mutableStateOf("Text RadioButton")
        }
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Row() {
                //If I want to make work with more than 1 radioButton we have to do this code
                RadioButton(
                    selected = selected == "Text RadioButton",
                    onClick = { selected = "Text RadioButton" })
                Text(text = "Text RadioButton")
            }

            Row() {
                RadioButton(
                    selected = selected == "Text RadioButton2",
                    onClick = { selected = "Text RadioButton2" })
                Text(text = "Text RadioButton2")
            }

            Row() {
                RadioButton(
                    selected = selected == "Text RadioButton3",
                    onClick = { selected = "Text RadioButton3" })
                Text(text = "Text RadioButton3")
            }

            Row() {
                RadioButton(
                    selected = selected == "Text RadioButton4",
                    onClick = { selected = "Text RadioButton4" })
                Text(text = "Text RadioButton4")
            }

            Row() {
                RadioButton(
                    selected = selected == "Text RadioButton5",
                    onClick = { selected = "Text RadioButton5" })
                Text(text = "Text RadioButton5")
            }
        }
    }

    @Composable
//We are going to add a radio button
    fun MyRadioButton() {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.White)
        ) {
            //The Radio button has 4 color when is enable selected, enable unselected, disable selected and disable unselected
            RadioButton(
                selected = true,
                onClick = { },
                colors = RadioButtonDefaults.colors(
                    disabledSelectedColor = Color.Green,
                    disabledUnselectedColor = Color.Red,
                    selectedColor = Color.Blue,
                    unselectedColor = Color.Cyan,
                )
            )
            Text(text = "Text RadioButton")
        }
    }


    @Composable
//We create a function that receive a list of strings and it returns a list of objects using the list of tittles
    fun CheckBoxOptionsList(tittles: List<String>): List<CheckInfo> {
        //For each tittle on the list we create a new object with that tittle
        return tittles.map {
            var checkState by remember { mutableStateOf(false) }
            //We return this object for each iteration of the list
            CheckInfo(
                //"it" is connect with map, each tittle that is mapped on the list is using here
                tittle = it, selected = checkState,
                //onCheckedChange = {checkState = it},
                onCheckedChange = { myNewStatus -> checkState = myNewStatus })
        }
    }


    //TriState CheckBox
    @Composable
    fun MyThreeStatusCheckBox() {
        var status by rememberSaveable {
            mutableStateOf(ToggleableState.Off)
        }
        TriStateCheckbox(state = status, onClick = {
            when (status) {
                ToggleableState.Off -> ToggleableState.On
                ToggleableState.On -> ToggleableState.Indeterminate
                ToggleableState.Indeterminate -> ToggleableState.Off
            }

        })
    }


    //Multiple CheckBox in a row, how to control all of it
    @Composable
//This function needs a parameter that is an object CheckInfo
    fun MultiCheckBox(checkInfo: CheckInfo) {
        //for this we create a class for oll check box named CheckInfo
        //We can not pass objects to the mutable State, so we go to MainActivity
        //And we modify the SetContent function.
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Checkbox(
                    //Here we receive the value of the object checkInfo, the parameter named selected
                    checked = checkInfo.selected,
                    //When we check the changes, apply the lambda and change the value to the opposite
                    onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
                Spacer(
                    modifier = Modifier.width(4.dp)
                )
                Text(text = checkInfo.tittle)


            }
        }


    }


    @Composable
    fun SelectionElementsCheckBox() {
        var booleanState by rememberSaveable { mutableStateOf(true) }
        var booleanCTState by rememberSaveable { mutableStateOf(true) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.White)
        ) {
            Checkbox(
                checked = booleanState,
                onCheckedChange = { booleanState = !booleanState },
                enabled = false,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    uncheckedColor = Color.Green,
                    checkmarkColor = Color.Black,
                )
            )

            //CheckboxWithText
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Checkbox(checked = booleanCTState,
                    onCheckedChange = { booleanCTState = !booleanCTState })
                Spacer(
                    modifier = Modifier.width(4.dp)
                )
                Text(text = stringResource(R.string.check_box_text_1))


            }
        }
    }


    @Composable
    fun SelectionElementsSwitch() {
        var booleanState by rememberSaveable { mutableStateOf(true) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {

            Switch(
                checked = booleanState,
                onCheckedChange = { booleanState = !booleanState },
                enabled = true,
                colors = SwitchDefaults.colors(
                    uncheckedThumbColor = Color.Red.copy(alpha = 0.9f),
                    uncheckedTrackColor = Color.Magenta.copy(alpha = 0.1f),
                    checkedThumbColor = Color.Green.copy(alpha = 0.8f),
                    checkedTrackColor = Color.Green.copy(alpha = 0.5f),
                    disabledUncheckedTrackColor = Color.Yellow,
                    disabledUncheckedThumbColor = Color.Yellow,
                    disabledCheckedTrackColor = Color.Blue,
                    disabledCheckedThumbColor = Color.Blue
                )

            )


        }

    }