package com.tutorialjetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            Scaffold(scaffoldState=scaffoldState) {
                var counter by remember {
                    mutableStateOf(0)
                }

                if (counter % 5 ==0 && counter > 0){
                    LaunchedEffect(key1 = scaffoldState.snackbarHostState){
                        scaffoldState.snackbarHostState.showSnackbar("Hello")
                    }
                }


                Row(modifier = Modifier.padding(5.dp)) {
                    Button(
                        modifier=Modifier.padding(start = 0.dp, top = 0.dp, end = 3.dp),

                        onClick = { counter++ }) {
                        Text(text = "Click me : $counter")
                    }

                    Button(onClick = { counter = 0 }) {
                        Text(text = "Clear counter")
                    }
                }

            }
        }
    }
}



