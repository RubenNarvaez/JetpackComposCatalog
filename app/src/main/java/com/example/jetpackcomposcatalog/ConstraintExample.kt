package com.example.jetpackcomposcatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyConstraintExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxRed,
            boxBlue,
            boxYellow,
            boxMagenta,
            boxGreen) = createRefs()

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                start.linkTo(boxRed.end)
                top.linkTo(boxRed.bottom)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                end.linkTo(boxRed.start)
                bottom.linkTo(boxRed.top)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                start.linkTo(boxRed.end)
                bottom.linkTo(boxRed.top)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                end.linkTo(boxRed.start)
                top.linkTo(boxRed.bottom)
            })
    }

}

@Composable
fun ConstraintExampleGuide(){
    ConstraintLayout (modifier = Modifier.fillMaxSize()) {
        //GuideLine is an invisible line that let you move any component to itself.
        //You can do it with exact measure
        //val startGuide = createGuideLineFromTop(16.dp)
        //or You can do it with percentages
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.25f)
        //create a box component
        val boxRed = createRef()

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            })


    }
}


@Composable
fun ConstraintBarrier(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed,
            boxGreen,
            boxYellow) = createRefs()

        //Barrier is a component that create a restriction between any others components in the layout
        //Here we are going to create a end Barrier between boxRed and boxGreen components
        //barrier declaration:
        val barrier = createEndBarrier(boxRed,boxGreen)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(parent.start, margin = 16.dp)
            })

        Box(modifier = Modifier
            .size(235.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(boxGreen.bottom)
                start.linkTo(parent.start,margin = 32.dp)

            })

        Box(modifier = Modifier
            .size(35.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(barrier)

            })
    }
}

@Preview
@Composable
fun ConstraintChain(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed,
            boxGreen,
            boxYellow) = createRefs()

        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(parent.start)
                end.linkTo(boxRed.start)
            })

        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                start.linkTo(boxGreen.end)
                end.linkTo(boxYellow.start)

            })

        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(boxRed.end)
                end.linkTo(parent.end)
            })

        //When we have several component linked between them we can create a chain
        //the chain give us more functions to manage this components.

        //ChainStyle.Packed Gather the components as much as possible
        createHorizontalChain(boxRed,boxGreen,boxYellow, chainStyle = ChainStyle.Packed)

        //ChainStyle.Spread separate the components with the same distance (default property)
        //createHorizontalChain(boxRed,boxGreen,boxYellow, chainStyle = ChainStyle.Spread)

        //Separate the components as much as possible
        //createHorizontalChain(boxRed,boxGreen,boxYellow, chainStyle = ChainStyle.SpreadInside)


    }
}