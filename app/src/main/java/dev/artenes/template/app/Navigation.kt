package dev.artenes.template.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import dev.artenes.template.app.samples.FieldsSampleScreen
import dev.artenes.template.app.samples.MainSamplesScreen
import dev.artenes.template.app.samples.NotificationsSampleScreen

@Composable
fun MainNavigation() {

    val navController = rememberNavController()
    val uri = "https://template.artenes.dev"

    NavHost(navController = navController, startDestination = "samples") {

        composable("main") {

            //add screen

        }

        composable("samples", deepLinks = listOf(navDeepLink { uriPattern = "$uri/samples" })) {

            MainSamplesScreen(
                navigateToFieldsSample = {
                    navController.navigate("fields")
                },
                navigateToNotificationsSample = {
                    navController.navigate("notifications")
                }
            )

        }

        composable("fields", deepLinks = listOf(navDeepLink { uriPattern = "$uri/fields" })) {

            FieldsSampleScreen(
                back = {
                    navController.popBackStack()
                }
            )

        }

        composable(
            "notifications",
            deepLinks = listOf(navDeepLink { uriPattern = "$uri/notifications" })
        ) {

            NotificationsSampleScreen(
                back = {
                    navController.popBackStack()
                }
            )

        }

    }
}
