package com.tutorialjetpackcompose.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tutorialjetpackcompose.model.user
import com.tutorialjetpackcompose.presentation.Destination.*

@Composable
fun NavigationHost(user: user){
    val navController = rememberNavController()

    NavHost(navController=navController, startDestination =  Pantalla1.route){
        composable(Pantalla1.route){
            Pantalla1(navegarPantalla2 = {userData ->
                navController.navigate(Pantalla2.createRoute(userData))
            })
        }
        composable(
            Pantalla2.route,
            arguments = listOf(navArgument("user"){defaultValue="Pantalla 2"}))
        { navBackStackEntry ->
           // var newText = navBackStackEntry.arguments?.getString("user")
            requireNotNull(user)
            Pantalla2(user)
        }
    }
}