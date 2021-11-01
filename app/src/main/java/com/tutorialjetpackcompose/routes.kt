package com.tutorialjetpackcompose

sealed class Routes(val route: String) {
    object Profile : Routes("profile")
}