package com.example.effecthandlers

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.commonlib.theme.ComposeT1Theme


class SideEffectActivity : ComponentActivity() {
    companion object {
        const val TAG = "SideEffectActivity"
    }
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember {
                mutableStateOf("")
            }
            
            ComposeT1Theme {
                Button(onClick = { text += "#"}) {
                    i++ //Increasing non-compose related code inside composable function
                    Text(text = text)
                    Log.d(TAG, "i = $i")
                }
            }
        }
    }
}