package com.example.jetpackcomposcatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun MyText() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        //This is the basic for text
        Text(text = "01 This is a text")
        //We can change text color
        Text(text = "This is a text", color = Color.Blue)
        // the weight of text
        Text(text = "02 This is a text", fontWeight = FontWeight.ExtraBold)
        Text(text = "03 This is a text", fontWeight = FontWeight.Light)
        Text(text = "04 This is a text", fontWeight = FontWeight.W600)
        Text(text = "05 This is a text", fontWeight = FontWeight.Thin)
        // the font, Cursive, default, Monospace, SanSerif, Serif, and customize
        Text(text = "06 This is a text", style = TextStyle(fontFamily = FontFamily.Cursive))
        // text Decoration, none, lineThrough, underline
        Text(
            text = "07 This is a text",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "08 This is a text",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "09 This is a text", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough)
                )
            )
        )
        // And Text Size, there are other options, but this are most relevant
        Text(text = "10 Prixxirp was Here", fontSize = 30.sp)


    }


}