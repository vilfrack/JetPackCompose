package com.tutorialjetpackcompose.presentation

import com.tutorialjetpackcompose.model.user

sealed class Destination(
    val route: String
){
    object Pantalla1:Destination("pantalla1")
    object Pantalla2:Destination("pantalla2/?userdata={user}"){
        fun createRoute(user: user) = "pantalla2/?userdata=$user"
    }
}
