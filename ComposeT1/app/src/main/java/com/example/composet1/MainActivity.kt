package com.example.composet1

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composet1.ui.theme.ComposeT1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeT1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colors.background
                    color = colorResource(id = R.color.purple_200)) {
                    MessageCard(Message("RD Sharma", "Maths book"))
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Box(contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.padding(start = 20.dp)) {
            Text(text = "Hello ${msg.author}!",
                modifier = Modifier.fillMaxWidth().height(40.dp),
                textAlign = TextAlign.Center)
            Text(text = "${msg.body}!",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
            Text(text = "Hello ${msg.author}!",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
            Text(text = "${msg.body}!",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
            Text(text = "Hello ${msg.author}!",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
            Text(text = "${msg.body}!",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
            Text(text = "Hello ${msg.author}!",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
            Text(text = "${msg.body}!",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
            Text(text = "Hello ${msg.author}!",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
            Text(text = "${msg.body}!",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
        }

    }

}

@Preview(name = "Light Mode", showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    ComposeT1Theme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize())
        {
            MessageCard(Message("RD Sharma", "Maths book"))
        }
    }
}

@Preview
@Composable
fun DefaultPreviewWithBG() {
    ComposeT1Theme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(),
            //color = MaterialTheme.colors.background
            color = colorResource(id = R.color.purple_200)
        )
        {
            MessageCard(Message("RD Sharma", "Maths book"))
        }
    }
}