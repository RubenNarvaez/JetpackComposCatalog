package com.example.jetpackcomposcatalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyComposableImage() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(25.dp)
            .background(Color.White)
    ) {
        //The image needs two parameters, and a short descriptions
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "This is an example",
            //and we can use transparency on the image with numbers between 0.0f anf 1.0f
            alpha = 0.5f
        )

        //Special Modifiers, here we are going to do a circular image with circular border
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "This is an example",
            // Clip allow us to cut the image, for example we can Rounded the corner of the image
            modifier = Modifier.clip(RoundedCornerShape(25f))
        )

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "This is an example",
            // Clip allow us to cut the image, for example we can Rounded the corner of the image
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.Yellow, CircleShape)
        )

        //We can work with Icons to that is very similar to a image, that works with material Design
        //the default size of the Icons is 24 x 24 and contains a easy way to color it

        Icon(
            imageVector = Icons.Rounded.ShoppingCart,
            contentDescription = "Icon",
            tint = Color.Blue
        )


    }
}
