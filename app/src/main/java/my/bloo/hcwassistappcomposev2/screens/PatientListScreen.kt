package my.bloo.hcwassistappcomposev2.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import my.bloo.hcwassistappcomposev2.BottomBarScreen
import my.bloo.hcwassistappcomposev2.graphs.Graph

//import my.bloomy.hcwassistappcompose.navigation.AUTH_GRAPH_ROUTE
//import my.bloomy.hcwassistappcompose.navigation.Screen

@Composable
fun PatientListScreen(
    navController: NavController = rememberNavController()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
//            modifier = Modifier.clickable {
//                navController.navigate(
//                    route = BottomBarScreen.Home.route
//                )
//            },
            text = "Patient List",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .padding(top = 150.dp)
                .clickable {
                    BottomBarScreen.Home.route
                },
            text = "Login/Sign Up",
            fontSize = MaterialTheme.typography.h6.fontSize,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PatientListScreenPreview() {
    PatientListScreen(
        navController = rememberNavController()
    )
}
