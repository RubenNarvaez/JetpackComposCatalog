package com.example.jetpackcomposcatalog.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.BadgeDefaults
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.exp


@Composable
//DropDownMenu, is a menu when you click an OutlinedTextField or any other component you can see a menu
//with options, in this case we are going to do a desserts list for a simple layout.
fun MyDropDownMenu() {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val desserts = listOf("IceCream", "Chocolate", "Coke", "etc", "ETC2")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            Modifier.fillMaxWidth()
        ) {
            desserts.forEach { desserts ->
                DropdownMenuItem(
                    text = {Text(text = desserts)},
                    onClick = {
                        expanded = false
                        selectedText = desserts
                    })
            }
        }

    }

}


@Composable
fun MyDivider() {
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(top = 24.dp), color = Color.Red, thickness = 8.dp
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Now we ar going to see the badgeBox
//The badgeBox have 2 parts on is an Image, in this case we are going to use an Icon
fun MyBadgeBox() {
    Column(Modifier.fillMaxSize()) {
        BadgedBox(
            badge = { Text(text = "12") },
            modifier = Modifier.padding(16.dp),
        ) {
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Description")
        }
    }
}


@Composable
//The cards are very useful for make prettier your app is just for decoration but give you a better look results
fun MyCard() {

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = Color.Green, contentColor = Color.Yellow
        )
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = "Example 1")
            Text(text = "Example 2")
            Text(text = "Example 3")
        }
    }
}