package com.tutorialjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tutorialjetpackcompose.ui.HomeScreen
import com.tutorialjetpackcompose.ui.theme.MeditationUIYouTubeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Home()
        }
    }
    @ExperimentalFoundationApi
    @Preview(showBackground = true,showSystemUi = true)
    @Composable
    fun Home(){
        MeditationUIYouTubeTheme {
            HomeScreen()
        }
    }
}


