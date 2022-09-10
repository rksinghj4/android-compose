package com.example.modifiers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.commonlib.theme.AnimationT1Theme
//import com.example.commonlib.theme.Theme
import com.example.modifiers.R

class ModifiersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationT1Theme {
                Surface(/*color = Theme.Theme2Trust.colors.background*/
                    color = Color.Yellow) {
                    Column {
                        ArtistCard(Artist("ARMAN", "5 minutes ago"))
                        ArtistCard(Artist("ARMAN", "5 minutes ago"))

                    }
                }
            }
        }
    }
}

data class Artist(val name: String, val lastSeenOnline: String)

@Composable
fun ArtistCard(artist: Artist) {
    Row(
        modifier = Modifier
            .size(width = 400.dp, height = 100.dp).padding(top=20.dp)
            .background(color = Color.Cyan, shape = RoundedCornerShape(10.dp))
            .border(1.5.dp, MaterialTheme.colors.secondaryVariant, RoundedCornerShape(5.dp))
    ) {
        Image(
            painter = painterResource(com.example.commonlib.R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier
                .requiredSize(150.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
        )
        Column {
            Text(
                text = artist.name,
                //TODO: modifier = Modifier.alignBy(alignmentLine = VerticalAlignmentLine(merger = ::merger1))
                modifier = Modifier.paddingFromBaseline(top = 50.dp)
            )
            Text(artist.lastSeenOnline)
        }
    }
}

fun merger1(a: Int, b: Int): Int = a+b

@Preview
@Composable
fun defaultPreview() {
    AnimationT1Theme {
        Surface(color = Color.Yellow) {
            Column {
                ArtistCard(Artist("ARMAN", "5 minutes ago"))
                ArtistCard(Artist("ARMAN", "5 minutes ago"))

            }        }
    }
}