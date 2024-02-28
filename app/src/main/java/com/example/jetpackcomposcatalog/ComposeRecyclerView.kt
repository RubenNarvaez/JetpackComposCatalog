@file:OptIn(ExperimentalFoundationApi::class)

package com.example.jetpackcomposcatalog

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@Composable
fun MySuperheroStickyView() {
    val context = LocalContext.current
    val superheroNameGroup = getSuperheroes().groupBy { it.superheroName }
    val superheroPublisher = getSuperheroes().groupBy { it.publisher }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        superheroPublisher.forEach { (publisher, mySuperhero) ->

            stickyHeader {
                Text(text = publisher, modifier=Modifier.fillMaxWidth().background(Color.LightGray), fontSize = 14.sp)
            }
            items(mySuperhero) { superhero ->
                ItemClickableHero(superhero = superhero)
                { Toast.makeText(context, superhero.superheroName, Toast.LENGTH_SHORT).show() }
            }
        }
    }
}

@Composable
fun MySpecialControlHeroRV() {
    val context = LocalContext.current
    //We need a variable to control the scroll state
    val rvState = rememberLazyListState()
    //For the button we need a corroutine scope
    val corroutineScope = rememberCoroutineScope()
    Column {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperheroes()) { superhero ->
                ItemClickableHero(superhero = superhero)
                { Toast.makeText(context, superhero.superheroName, Toast.LENGTH_SHORT).show() }
            }
        }
        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }
        if (showButton) {
            Button(
                onClick = {
                    //when we click the button we call a coroutine to Scroll to top
                    corroutineScope.launch {
                        rvState.animateScrollToItem(0)
                    }
                }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = "I am the BUTTON")

            }
        }
    }
}

@Composable
fun MySuperheroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(getSuperheroes()) { superhero ->
            ItemClickableHero(superhero = superhero)
            { Toast.makeText(context, superhero.superheroName, Toast.LENGTH_SHORT).show() }
        }
    }
}


@Composable
fun MySuperheroClickableView() {
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperheroes()) { superhero ->
            ItemClickableHero(superhero = superhero)
            { Toast.makeText(context, superhero.superheroName, Toast.LENGTH_SHORT).show() }
        }
    }
}

@Composable
fun ItemClickableHero(superhero: Superhero, onItemSelected: (Superhero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(superhero) }
            .padding(top = 8.dp, bottom = 8.dp, end = 12.dp, start = 16.dp))
    {
        Column {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "Superhero photo",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superhero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
                fontSize = 10.sp
            )

        }
    }

}

@Composable
fun MySuperheroView() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperheroes()) {
            ItemHero(superhero = it)
        }

    }
}

@Composable
fun ItemHero(superhero: Superhero) {
    Card(border = BorderStroke(2.dp, Color.Red), modifier = Modifier.width(200.dp)) {
        Column {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "Superhero photo",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superhero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
                fontSize = 10.sp
            )

        }
    }

}


@Composable
fun MySimpleRecyclerView3() {
    val myList = listOf("Pat", "Nat", "Ale", "Laura", "Martina")
    LazyColumn {
        item { Text(text = "Hello item 1") }
        items(myList) {
            Text(text = "This name of the item is $it")
        }
    }
}

@Composable
fun MySimpleRecyclerView2() {
    LazyColumn {
        item { Text(text = "Hello item 1") }
        items(7) {
            Text(text = "This is item $it")
        }
    }
}

@Composable
fun MySimpleRecyclerView1() {
    LazyColumn {
        item { Text(text = "Hello item 1") }
        item { Text(text = "Hello item 1") }
        item { Text(text = "Hello item 1") }
        item { Text(text = "Hello item 1") }
        item { Text(text = "Hello item 1") }
        item { Text(text = "Hello item 1") }
        item { Text(text = "Hello item 1") }
    }
}

//This is a normal function
fun getSuperheroes(): List<Superhero> {
    return listOf(
        Superhero("Spider-man", "Peter Parker", "Marvel", R.drawable.spiderman),
        Superhero("Wolverine", "Peter Parker", "Marvel", R.drawable.logan),
        Superhero("Batman", "Peter Parker", "DC-Comics", R.drawable.batman),
        Superhero("Thor", "Peter Parker", "Marvel", R.drawable.thor),
        Superhero("Flash", "Peter Parker", "DC-Comics", R.drawable.flash),
        Superhero("Green Lantern", "Peter Parker", "Marvel", R.drawable.green_lantern),
        Superhero("Wonder Woman", "Peter Parker", "DC-Comics", R.drawable.wonder_woman),
        Superhero("Spider-man", "Peter Parker", "Marvel", R.drawable.spiderman),
        Superhero("Wolverine", "Peter Parker", "Marvel", R.drawable.logan),
        Superhero("Batman", "Peter Parker", "DC-Comics", R.drawable.batman),
        Superhero("Thor", "Peter Parker", "Marvel", R.drawable.thor),
        Superhero("Flash", "Peter Parker", "DC-Comics", R.drawable.flash),
        Superhero("Green Lantern", "Peter Parker", "Marvel", R.drawable.green_lantern),
        Superhero("Wonder Woman", "Peter Parker", "DC-Comics", R.drawable.wonder_woman),
        Superhero("Spider-man", "Peter Parker", "Marvel", R.drawable.spiderman),
        Superhero("Wolverine", "Peter Parker", "Marvel", R.drawable.logan),
        Superhero("Batman", "Peter Parker", "DC-Comics", R.drawable.batman),
        Superhero("Thor", "Peter Parker", "Marvel", R.drawable.thor),
        Superhero("Flash", "Peter Parker", "DC-Comics", R.drawable.flash),
        Superhero("Green Lantern", "Peter Parker", "Marvel", R.drawable.green_lantern),
        Superhero("Wonder Woman", "Peter Parker", "DC-Comics", R.drawable.wonder_woman)
    )
}
