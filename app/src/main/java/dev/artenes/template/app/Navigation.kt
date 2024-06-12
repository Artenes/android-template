package dev.artenes.template.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.artenes.template.app.samples.SamplesScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "samples") {

        composable("main") {

            //add screen

        }

        composable("samples") {

            SamplesScreen()

        }

    }
}
