package my.bloo.hcwassistappcomposev2.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import my.bloo.hcwassistappcomposev2.BottomBarScreen
import my.bloo.hcwassistappcomposev2.CustomItem
import my.bloo.hcwassistappcomposev2.graphs.Graph
import my.bloo.hcwassistappcomposev2.repository.PersonRepository

//import my.bloomy.hcwassistappcompose.navigation.AUTH_GRAPH_ROUTE
//import my.bloomy.hcwassistappcompose.navigation.Screen

@Composable
fun PatientForm01Screen(
    onSignUpClick: () -> Unit
) {
    val personRepository = PersonRepository()
    val getAllData = personRepository.getAllData()

    LazyColumn(contentPadding = PaddingValues(10.dp)) {
        item {
            RadioGroupSample()
        }
    }

}


@Composable
private fun RadioGroupSample() {
    /* Here Create List for radioButton */
    val radioOptions = listOf("Red Color", "Blue Color", "Black Color", "White Color")
    /* Here Create State of radioButton */
    var selectedOption by remember { mutableStateOf("") }

    Card(
        backgroundColor = MaterialTheme.colors.primary.copy(0.04f),
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        elevation = 0.dp,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, MaterialTheme.colors.primary.copy(0.5f)),
    ) {

        Column(Modifier.padding(10.dp)) {

            Text(
                text = "Radio Group example :",
                style = MaterialTheme.typography.h6
            )

//            Spacer(spaceModifier)

            radioOptions.forEach { text ->
                Row(Modifier
                    .padding(bottom = 10.dp)
                    .wrapContentSize()
                    .clickable(
                        onClick = {
                            selectedOption = text
//                            showToast("$selectedOption selected")
                        }
                    ), verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = {
                            selectedOption = text
//                            showToast("$selectedOption selected")
                        },
                        colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colors.primaryVariant)
                    )
                    Text(
                        text = text,
                        modifier = Modifier.padding(start = 10.dp, end = 20.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun showToast(message: String) {
    Toast.makeText(LocalContext.current, message, Toast.LENGTH_SHORT).show()
}

@Composable
@Preview(showBackground = true)
fun PatientForm01ScreenPreview() {
    PatientForm01Screen(
        {}
    )
}
