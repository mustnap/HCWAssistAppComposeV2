package my.bloo.hcwassistappcomposev2.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import my.bloo.hcwassistappcomposev2.CustomItem
import my.bloo.hcwassistappcomposev2.graphs.Graph
import my.bloo.hcwassistappcomposev2.repository.PersonRepository

//import my.bloomy.hcwassistappcompose.navigation.AUTH_GRAPH_ROUTE
//import my.bloomy.hcwassistappcompose.navigation.Screen

@Composable
fun PatientListScreen(
    onSignUpClick: () -> Unit
) {
    val personRepository = PersonRepository()
    val getAllData = personRepository.getAllData()

    LazyColumn() {
        items(items = getAllData) {
            person -> CustomItem(person = person, onSignUpClick )
        }
    }

}

@Composable
@Preview(showBackground = true)
fun PatientListScreenPreview() {
    PatientListScreen(
        {}
    )
}
