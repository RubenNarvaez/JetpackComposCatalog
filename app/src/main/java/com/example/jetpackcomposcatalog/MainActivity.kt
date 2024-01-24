package com.example.jetpackcomposcatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposcatalog.ui.theme.JetpackComposCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MyBox()
                }
            }
        }
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd) {
        Box(
            modifier = Modifier
                .height(30.dp)
                .width(30.dp)
                .background(Color.Cyan)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            Text("Este es un texto dentro de un box")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposCatalogTheme {
        MyBox()
    }
}