package com.example.filemanager.compose.navigation

sealed class Screen(val route: String){
    object WelcomePage : Screen("welcome_screen")
    object HomeInternal : Screen("home_internal")
}
