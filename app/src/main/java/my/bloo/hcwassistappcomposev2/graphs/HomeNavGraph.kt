package my.bloo.hcwassistappcomposev2.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import my.bloo.hcwassistappcomposev2.BottomBarScreen
import my.bloo.hcwassistappcomposev2.screens.ScreenContent
import my.bloo.hcwassistappcomposev2.screens.PatientListScreen
import my.bloo.hcwassistappcomposev2.screens.PatientForm01Screen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            ScreenContent(
                name = BottomBarScreen.Home.route,
                onClick = {
                    navController.navigate(Graph.DETAILS)
                }
            )
        }
        composable(route = BottomBarScreen.Patient.route) {
            PatientListScreen(
                onSignUpClick = {
                navController.popBackStack()
                navController.navigate(Graph.PATIENTREADINGS)
            } )
        }
        composable(route = BottomBarScreen.Settings.route) {
            ScreenContent(
                name = BottomBarScreen.Settings.route,
                onClick = { }
            )
        }
        detailsNavGraph(navController = navController)
        patientReadingsNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route) {
            ScreenContent(name = DetailsScreen.Information.route) {
                navController.navigate(DetailsScreen.Overview.route)
            }
        }
        composable(route = DetailsScreen.Overview.route) {
            ScreenContent(name = DetailsScreen.Overview.route) {
                navController.popBackStack(
                    route = DetailsScreen.Information.route,
                    inclusive = false
                )
            }
        }
    }
}


fun NavGraphBuilder.patientReadingsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PATIENTREADINGS,
        startDestination = PatientReadingScreen.Reading.route
    ) {
        composable(route = PatientReadingScreen.Reading.route) {
            PatientForm01Screen() {
                navController.navigate(PatientReadingScreen.Overview.route)
            }
        }
        composable(route = PatientReadingScreen.Overview.route) {
            ScreenContent(name = PatientReadingScreen.Overview.route) {
                navController.popBackStack(
                    route = PatientReadingScreen.Reading.route,
                    inclusive = false
                )
            }
        }
    }
}


sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(route = "INFORMATION")
    object Overview : DetailsScreen(route = "OVERVIEW")
}


sealed class PatientReadingScreen(val route: String) {
    object Reading : PatientReadingScreen(route = "PATIENTREADING")
    object Overview : PatientReadingScreen(route = "OVERVIEW")
}

