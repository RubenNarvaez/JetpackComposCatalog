package com.example.jetpackcomposcatalog

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable

fun MyColorAnimation() {
    Column {
        //this is the way that we can change the color in a box background
        var firstColor by rememberSaveable {
            mutableStateOf(false)
        }
        val realColor = if (firstColor) Color.Red else Color.Yellow
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { firstColor = !firstColor })
        //******************
        Spacer(modifier = Modifier.size(100.dp))
        //******************

        //this is the way that we can animate the color in a box background
        var secondColor by rememberSaveable {
            mutableStateOf(false)
        }
        val realColor2 by animateColorAsState(
            targetValue = if (secondColor) Color.Red else Color.Yellow,
            label = "Animated Color background change"
        )
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor2)
            .clickable { secondColor = !secondColor })


        //******************
        Spacer(modifier = Modifier.size(100.dp))
        //******************

        //this is the advanced way that we can animate the color in a box background
        var showBox by rememberSaveable {
            mutableStateOf(true)
        }
        var thirdColor by rememberSaveable {
            mutableStateOf(false)
        }
        val realColor3 by animateColorAsState(targetValue = if (thirdColor) Color.Red else Color.Yellow,
            label = "Aris el puto amo",
            //We can add a animationSpec that is a time un milliseconds
            animationSpec = tween(2000),
            //And we can add a listener that is triggered when the animations has finished
            finishedListener = { showBox = false })
        if (showBox) {
            Box(modifier = Modifier
                .size(100.dp)
                .background(realColor3)
                .clickable { thirdColor = !thirdColor })
        }
    }
}

@Composable
fun MySizeAnimation() {
    Column {


        //For size we need two parameters
        var smallSize by rememberSaveable {
            mutableStateOf(true)
        }
        val size by animateDpAsState(
            targetValue = (if (smallSize) 50.dp else 100.dp), label = "Animate size"
        )
        Box(modifier = Modifier
            .size(size)
            .background(Color.Cyan)
            .clickable { smallSize = !smallSize })

        //******************
        Spacer(modifier = Modifier.size(100.dp))
        //******************

        // For animate correctly tha size, we are going to use the same process than color
        var sizeBoxVisibility by rememberSaveable {
            mutableStateOf(true)
        }
        var smallSize2 by rememberSaveable {
            mutableStateOf(true)
        }
        val size2 by animateDpAsState(targetValue = (if (smallSize2) 50.dp else 100.dp),
            label = "Animate size",
            animationSpec = tween(2000),
            finishedListener = { sizeBoxVisibility = false })
        if (sizeBoxVisibility) {
            Box(modifier = Modifier
                .size(size2)
                .background(Color.Cyan)
                .clickable { smallSize2 = !smallSize2 })
        }
    }
}

@Composable
fun MyVisibilityAnimation() {
    var visibilityState by rememberSaveable {
        mutableStateOf(true)
    }
    var visibilityState2 by rememberSaveable {
        mutableStateOf(true)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { visibilityState = !visibilityState }) {
            Text(text = "Show/Hide")
        }
        if (visibilityState) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Cyan)

            )
        }

        //******************
        Spacer(modifier = Modifier.size(100.dp))
        //******************
        Button(onClick = { visibilityState2 = !visibilityState2 }) {
            Text(text = "Show/Hide")
        }
        AnimatedVisibility(visibilityState2) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Cyan)

            )
        }
    }
}

@Composable
fun MyCrossFadeAnimation() {

    var myComponentType: ComponentType by rememberSaveable {
        mutableStateOf(ComponentType.Text)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        //Here we go to crete a button that change component.
        Button(onClick = { myComponentType = getComponentTypeRandom() }) {
            Text(text = "ChangeComponent")
        }

        when (myComponentType) {
            ComponentType.Text -> {
                Icon(Icons.Default.Send, contentDescription = "New Icon")
            }

            ComponentType.Image -> Text(text = "Here is the text")
            ComponentType.Box -> Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red)
            )

            ComponentType.Error -> Text(text = "Error! Error! Error!")
        }

        Spacer(modifier = Modifier.size(150.dp))

        var myComponentType2: ComponentType by rememberSaveable {
            mutableStateOf(ComponentType.Text)
        }

        Button(onClick = { myComponentType2 = getComponentTypeRandom() }) {
            Text(text = "ChangeComponent")
        }

        Crossfade(targetState = myComponentType2, label = "CrossFading", animationSpec = tween(2000)) {
            when (it) {
                ComponentType.Text -> {
                    Icon(Icons.Default.Send, contentDescription = "New Icon")
                }

                ComponentType.Image -> Text(text = "Here is the text")
                ComponentType.Box -> Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Red)
                )

                ComponentType.Error -> Text(text = "Error! Error! Error!")
            }
        }

    }

}

fun getComponentTypeRandom(): ComponentType {
    return when (nextInt(from = 0, until = 3)) {
        0 -> ComponentType.Text
        1 -> ComponentType.Image
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }

}

enum class ComponentType {
    Image, Text, Box, Error
}

















































