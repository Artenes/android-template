package dev.artenes.template.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.artenes.template.app.samples.FieldsSampleScreen
import dev.artenes.template.app.samples.MainSamplesScreen
import dev.artenes.template.app.samples.NotificationsSampleScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "samples") {

        composable("main") {

            //add screen

        }

        composable("samples") {

            MainSamplesScreen(
                navigateToFieldsSample = {
                    navController.navigate("fields")
                },
                navigateToNotificationsSample = {
                    navController.navigate("notifications")
                }
            )

        }

        composable("fields") {

            FieldsSampleScreen(
                back = {
                    navController.popBackStack()
                }
            )

        }

        composable("notifications") {

            NotificationsSampleScreen(
                back = {
                    navController.popBackStack()
                }
            )

        }

    }
}
