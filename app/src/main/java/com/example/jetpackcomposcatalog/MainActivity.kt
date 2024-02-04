package com.example.jetpackcomposcatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
                    /*
                    //STATE HOISTING
                    var myTextState by remember { mutableStateOf("Initial text:") }
                    MyTextField(myTextState) {myTextState=it}
                    */
                    MyComposableButton()


                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    JetpackComposCatalogTheme {

    }
}
@Composable
fun MyRow() {/*Row (Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = "Example1")
        Text(text = "Example2")
        Text(text = "Example3")
    }*/

    /*Row (Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = "Example1",modifier = Modifier.weight(1f))
        Text(text = "Example2",modifier = Modifier.weight(1f))
        Text(text = "Example3",modifier = Modifier.weight(1f))
        Text(text = "Example4",modifier = Modifier.weight(1f))
    }*/

    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Example1", modifier = Modifier.width(100.dp))
        Text(text = "Example2", modifier = Modifier.width(100.dp))
        Text(text = "Example3", modifier = Modifier.width(100.dp))
        Text(text = "Example4", modifier = Modifier.width(100.dp))
        Text(text = "Example5", modifier = Modifier.width(100.dp))
        Text(text = "Example6", modifier = Modifier.width(100.dp))
    }


}

@Composable
fun MyColumn() {

    /*A Column can use Weights for the size depend the number you put in the weight,
     you can make it bigger,smaller, or the same size. */

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            "Ejemplo 1", modifier = Modifier
                .background(Color.Blue)
                .weight(1f)
        )
        Text(
            "Ejemplo 2", modifier = Modifier
                .background(Color.Red)
                .weight(1f)
        )
        Text(
            "Ejemplo 3", modifier = Modifier
                .background(Color.Yellow)
                .weight(1f)
        )
        Text(
            "Ejemplo 4", modifier = Modifier
                .background(Color.Cyan)
                .weight(1f)
        )
        Text(
            "Ejemplo 5", modifier = Modifier
                .background(Color.Gray)
                .weight(1f)
        )
    }

    /*Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text("Ejemplo 1", modifier = Modifier.background(Color.Blue))
        Text("Ejemplo 2", modifier = Modifier.background(Color.Red))
        Text("Ejemplo 3", modifier = Modifier.background(Color.Yellow))
        Text("Ejemplo 4", modifier = Modifier.background(Color.Cyan))
        Text("Ejemplo 5", modifier = Modifier.background(Color.Gray))
    }
    */

    /*  Column(modifier = Modifier
          .fillMaxSize()
          .verticalScroll(rememberScrollState()), verticalArrangement =Arrangement.SpaceBetween){
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
          Text("Ejemplo 1", modifier = Modifier
              .background(Color.Blue)
              .fillMaxWidth()
              .height(100.dp))
      }*/
}


/* This is the view of a composable Box */

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

/* This is the site where the preview is loaded, you can show more than one preview at once*/
