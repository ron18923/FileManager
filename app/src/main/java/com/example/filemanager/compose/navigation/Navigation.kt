package com.example.filemanager.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.filemanager.compose.homeScreen.Home
import com.example.filemanager.compose.WelcomePage

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.WelcomePage.route){
        composable(route = Screen.WelcomePage.route){
            WelcomePage(navController = navController)
        }
        composable (route = Screen.HomeInternal.route){
            Home()
        }
    }
}