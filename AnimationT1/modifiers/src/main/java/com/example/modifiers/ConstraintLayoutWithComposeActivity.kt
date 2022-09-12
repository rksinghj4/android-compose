package com.example.modifiers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

class ConstraintLayoutWithComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintSet2()
        }
    }
}

@Composable
fun ConstraintSet1() {
    val constraintSet = ConstraintSet {
        val greenBox = createRefFor(id = "greenBox")
        val redBox = createRefFor(id = "redBox")

        constrain(greenBox) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(redBox) {
            start.linkTo(greenBox.end)
            top.linkTo(parent.top)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
    }

    ConstraintLayout(constraintSet = constraintSet, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .background(Color.Green)
            .layoutId("greenBox")) {

        }

        Box(modifier = Modifier
            .background(Color.Red)
            .layoutId("redBox")) {

        }
    }
}


@Composable
fun ConstraintSet2() {
    //Decoupled the ConstraintSet from ConstraintLayout. Later on it can be passed as parameter in
    //ConstraintLayout
    val constraintSet = ConstraintSet {
        //Create reference for each individual composable (i.e. UI elements)
        val textField1 = createRefFor(id = "textField1")
        val textField2 = createRefFor(id = "textField2")

        val greenBox = createRefFor(id = "greenBox")
        val redBox = createRefFor(id = "redBox")

        val guideline = createGuidelineFromTop(.5f)
        val barriers = createEndBarrier(textField1, textField2, margin = 10.dp)

        constrain(textField1) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        }
        constrain(textField2) {
            start.linkTo(parent.start)
            top.linkTo(textField1.bottom)
        }
        constrain(greenBox) {
            start.linkTo(barriers)
            top.linkTo(guideline)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(redBox) {
            start.linkTo(greenBox.end)
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }
    }

    ConstraintLayout(constraintSet = constraintSet, modifier = Modifier.fillMaxSize()) {
        var text1 by remember {
            mutableStateOf(TextFieldValue("Input1"))
        }
        var text2 by remember {
            mutableStateOf(TextFieldValue("Input2"))
        }

        TextField(modifier = Modifier
            .layoutId("textField1").widthIn(min = 60.dp, max = 250.dp),
            value = text1, onValueChange = { text1 = it })

        TextField(modifier = Modifier
            .layoutId("textField2").widthIn(min = 60.dp, max = 250.dp),
            value = text2, onValueChange = { text2 = it })

        Box(modifier = Modifier
            .background(Color.Green)
            .layoutId("greenBox")) {

        }

        Box(modifier = Modifier
            .background(Color.Red)
            .layoutId("redBox")) {

        }
    }
}

@Preview
@Composable
fun ConstraintSet1Preview() {
    ConstraintSet1()
}

@Preview
@Composable
fun ConstraintSet2Preview() {
    ConstraintSet2()
}
