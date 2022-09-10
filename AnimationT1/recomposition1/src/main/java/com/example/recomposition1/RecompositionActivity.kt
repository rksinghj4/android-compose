package com.example.recomposition1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.commonlib.theme.AnimationT1Theme
import com.example.recomposition1.viewmodel.RecompositionViewModel

class RecompositionActivity : ComponentActivity() {

    private val recompositionViewModel by viewModels<RecompositionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationT1Theme {
                Surface {
                    Column {
                        val stateOfStudentData =
                            recompositionViewModel.studentListState
                        /*  ListComposable(recompositionViewModel.mutableStudentListState, recompositionViewModel.mutableStudentListState.size)
                          takeInput(recompositionViewModel)
                          ListWithBug(recompositionViewModel.mutableStudentListState, recompositionViewModel.mutableStudentListState.size)
    */
                        ListComposableWithLazy(stateOfStudentData.value,
                            stateOfStudentData.value.size)
                        ListComposableWithLazyAndBug(stateOfStudentData.value,
                            stateOfStudentData.value.size)
                        TakeInput(recompositionViewModel)
                        ListComposable(stateOfStudentData.value,
                            stateOfStudentData.value.size)
                        ListWithBug(stateOfStudentData.value,
                            stateOfStudentData.value.size)
                    }
                }
            }
        }
    }
}

@Composable
fun ListComposableWithLazy(myList: List<String>, viewModelCount: Int = 0) {
    Box(Modifier.wrapContentSize()) {
        Row(Modifier.padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            LazyColumn(Modifier.wrapContentSize()) {
                items(myList) { item ->
                    Text("Item: $item")
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text("Count: ${myList.size}", textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.width(10.dp))
            Text("VMCount: $viewModelCount", textAlign = TextAlign.Center)
        }
    }

}

@Deprecated("Example with bug/LazyColumn")
@Composable
fun ListComposableWithLazyAndBug(myList: List<String>, viewModelCount: Int = 0) {
   /* var count by remember {//infinite loop problem
        mutableStateOf(0)
    }
*/
    var count = 0 //
    Box(Modifier.wrapContentSize()) {
        Row(Modifier
            .padding(10.dp)
            .fillMaxWidth(1f)) {
            LazyColumn(Modifier.fillMaxWidth(.4f), reverseLayout = true) {
                items(myList) { item ->
                    run {
                        Text("Item: $item")
                        count++
                        /*if (count < myList.size) {
                            count++ // Avoid! Side-effect of the column recomposing.
                        }*/
                        Log.d("Count", "Lazy Count = $count")
                    }
                }
            }

            Column(Modifier.fillMaxWidth(.6f), verticalArrangement = Arrangement.SpaceEvenly) {
                Spacer(modifier = Modifier.width(10.dp))
                Text("Count: $count", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "VMCount: $viewModelCount",
                    textAlign = TextAlign.Center)
                Log.d("Count", "Count = $count")

            }
        }
    }

}


@Composable
fun ListComposable(myList: List<String>, viewModelCount: Int = 0) {
    Box(Modifier.wrapContentSize()) {
        Row(Modifier.padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                for (item in myList) {
                    Text("Item: $item")
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text("Count: ${myList.size}", textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.width(10.dp))
            Text("VMCount: $viewModelCount", textAlign = TextAlign.Center)
        }
    }

}

/**
 * Above code is side-effect free, and transforms the input list to UI. This is great code
 * for displaying a small list. However, if the function writes to a local variable,
 * this code will not be thread-safe or correct:
 */

@Composable
@Deprecated("Example with bug")
fun ListWithBug(myList: List<String>, viewModelCount: Int = 0) {
    var items = 0

    Row(Modifier.padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Column {
            for (item in myList) {
                Text("Item: $item")
                items++ // Avoid! Side-effect of the column recomposing.
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text("Count: $items", textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.width(10.dp))
        Text("VMCount: $viewModelCount", textAlign = TextAlign.Center)
    }
}

@Composable
fun TakeInput(recompositionViewModel: RecompositionViewModel) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(modifier = Modifier.padding(10.dp), value = text, onValueChange = { newText ->
        text = newText
    })

    Button(modifier = Modifier.padding(10.dp), onClick = {
        recompositionViewModel.putAtFirst(text.text)
    }) {
        Text(text = "Submit")
    }
}