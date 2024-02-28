@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jetpackcomposcatalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

//The scaffold is another type of Layout that allows you to put different elements
@Composable
fun MyScaffoldExample() {
    //The scaffold need to save it state, for example with the SnackBar
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                MyDrawer {
                    coroutineScope.launch { drawerState.apply { close() } }
                }
            }
        }) {

    }

    Scaffold(
        topBar = {
            MyTopAppBar(
                onClickIcon = {
                    coroutineScope.launch {
                        snackBarHostState.showSnackbar(
                            message = "You press $it",
                            duration = SnackbarDuration.Short
                        )
                    }
                },
                onClickDrawer = {
                    coroutineScope.launch {
                        drawerState.apply { if (isClosed) open() else close() }
                    }
                }
            )

        },
        bottomBar = { MyBottomNavigation() },

        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
        floatingActionButton = { MyFab() },
        floatingActionButtonPosition = FabPosition.Center,


        ) {
        it
    }
}

@Composable
fun MyFab() {
    FloatingActionButton(onClick = {}, containerColor = Color.Yellow) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
    }
}


@Composable
fun MyBottomNavigation() {
    //For this example we only want one Icon selected at once not all
    var index by remember { mutableIntStateOf(0) }
    NavigationBar(containerColor = Color.Blue, contentColor = Color.White, tonalElevation = 8.dp) {

        NavigationBarItem(selected = index == 0, onClick = { index = 0 }, icon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
        }, label = { Text(text = "Home") })

        NavigationBarItem(selected = index == 1, onClick = { index = 1 }, icon = {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "Home")
        }, label = { Text(text = "Favorite") })

        NavigationBarItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(imageVector = Icons.Default.Person, contentDescription = "Home")
        }, label = { Text(text = "Person") })
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onClickDrawer: () -> Unit) {


    TopAppBar(title = { Text(text = "My first Top App Bar") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { onClickDrawer() }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Search") }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            }
            IconButton(onClick = { onClickIcon("E-mail") }) {
                Icon(imageVector = Icons.Default.Email, contentDescription = "E-mail")
            }
        })
}


@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {

    //val optionList = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
    Column(modifier = Modifier.padding(8.dp)) {
        //optionList.forEach {
        Text(text = "Option 1",
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .clickable { onCloseDrawer() })
        Text(text = "Option 2",
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .clickable { onCloseDrawer() })
        Text(text = "Option 3",
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .clickable { onCloseDrawer() })
        Text(text = "Option 4",
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .clickable { onCloseDrawer() })
    }

}
