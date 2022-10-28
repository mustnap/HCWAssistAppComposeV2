package my.bloo.hcwassistappcomposev2.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
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
            Spo2()
            BloodPressure()
            HeartRate()
            RespiratoryRate()
            TemperatureRange()
            ConsciousLevel()
            OxygenDelivery()
            CapilaryRefillTime()
        }
    }
}


@Composable
private fun HeartRate() {
    // Phone number textfield with max length as 10

    var heartRateText by remember { mutableStateOf("") }
    var showError: Boolean by remember { mutableStateOf(false) }

    val phoneNumber = remember { FocusRequester() }

    OutlinedTextField(
        value = heartRateText,
        onValueChange = {
            if (it.length <= 10) heartRateText = it
        },
        label = { Text("Enter heart rate") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
        ),
        isError = showError,
        modifier = Modifier.focusRequester(phoneNumber)
//        keyboardActions = KeyboardActions(onNext = { password.requestFocus() })
    )
}


@Composable
private fun BloodPressure() {
    // Phone number textfield with max length as 10

    var bloodPressureText by remember { mutableStateOf("") }
    var showError: Boolean by remember { mutableStateOf(false) }

    val bloodpressure = remember { FocusRequester() }

    OutlinedTextField(
        value = bloodPressureText,
        onValueChange = {
            if (it.length <= 10) bloodPressureText = it
        },
        label = { Text("Enter blood pressure") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
        ),
        isError = showError,
        modifier = Modifier.focusRequester(bloodpressure)
//        keyboardActions = KeyboardActions(onNext = { password.requestFocus() })
    )
}



@Composable
private fun Spo2() {
    // Phone number textfield with max length as 10

    var spo2Text by remember { mutableStateOf("") }
    var showError: Boolean by remember { mutableStateOf(false) }

    val phoneNumber = remember { FocusRequester() }

    OutlinedTextField(
        value = spo2Text,
        onValueChange = {
            if (it.length <= 10) spo2Text = it
        },
        label = { Text("Enter Spo2") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
        ),
        isError = showError,
        modifier = Modifier.focusRequester(phoneNumber)
//        keyboardActions = KeyboardActions(onNext = { password.requestFocus() })
    )
}


@Composable
private fun RespiratoryRate() {
    // Phone number textfield with max length as 10

    var respiratoryRateText by remember { mutableStateOf("") }
    var showError: Boolean by remember { mutableStateOf(false) }

    val phoneNumber = remember { FocusRequester() }

    OutlinedTextField(
        value = respiratoryRateText,
        onValueChange = {
            if (it.length <= 10) respiratoryRateText = it
        },
        label = { Text("Enter respiratory rate") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
        ),
        isError = showError,
        modifier = Modifier.focusRequester(phoneNumber)
//        keyboardActions = KeyboardActions(onNext = { password.requestFocus() })
    )
}



@Composable
private fun TemperatureRange() {
    /* Here Create List for radioButton */
    val radioOptions = listOf("less than 36.5", "between 36-37.4", "between 37.5-37.9", "between 38-39", "40 and above")
    /* Here Create State of radioButton */
    var selectedOption by remember { mutableStateOf("") }

    Card(
        backgroundColor = MaterialTheme.colors.primary.copy(0.04f),
        modifier = Modifier
            .padding(vertical = 5.dp)
            .fillMaxWidth(),
        elevation = 0.dp,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, MaterialTheme.colors.primary.copy(0.5f)),
    ) {

        Column(Modifier.padding(6.dp)) {

            Text(
                text = "Temperature Range :",
                style = MaterialTheme.typography.h6
            )

//            Spacer(spaceModifier)

            radioOptions.forEach { text ->
                Row(Modifier
                    .padding(bottom = 3.dp)
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
                        modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}



@Composable
private fun ConsciousLevel() {
    /* Here Create List for radioButton */
    val radioOptions = listOf("alert", "verbal", "pain", "unconscious")
    /* Here Create State of radioButton */
    var selectedOption by remember { mutableStateOf("") }

    Card(
        backgroundColor = MaterialTheme.colors.primary.copy(0.04f),
        modifier = Modifier
            .padding(vertical = 5.dp)
            .fillMaxWidth(),
        elevation = 0.dp,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, MaterialTheme.colors.primary.copy(0.5f)),
    ) {

        Column(Modifier.padding(6.dp)) {

            Text(
                text = "Conscious Level :",
                style = MaterialTheme.typography.h6
            )

//            Spacer(spaceModifier)

            radioOptions.forEach { text ->
                Row(Modifier
                    .padding(bottom = 3.dp)
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
                        modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}


@Composable
private fun OxygenDelivery() {
    /* Here Create List for radioButton */
    val radioOptions = listOf("room air", "nasal prong", "cpap", "nippv","ventilated")
    /* Here Create State of radioButton */
    var selectedOption by remember { mutableStateOf("") }

    Card(
        backgroundColor = MaterialTheme.colors.primary.copy(0.04f),
        modifier = Modifier
            .padding(vertical = 5.dp)
            .fillMaxWidth(),
        elevation = 0.dp,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, MaterialTheme.colors.primary.copy(0.5f)),
    ) {

        Column(Modifier.padding(6.dp)) {

            Text(
                text = "Oxygen Delivery :",
                style = MaterialTheme.typography.h6
            )

//            Spacer(spaceModifier)

            radioOptions.forEach { text ->
                Row(Modifier
                    .padding(bottom = 3.dp)
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
                        modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}



@Composable
private fun CapilaryRefillTime() {
    /* Here Create List for radioButton */
    val radioOptions = listOf("less than 2 sec", "3-4 sec", "5 sec or more")
    /* Here Create State of radioButton */
    var selectedOption by remember { mutableStateOf("") }

    Card(
        backgroundColor = MaterialTheme.colors.primary.copy(0.04f),
        modifier = Modifier
            .padding(vertical = 5.dp)
            .fillMaxWidth(),
        elevation = 0.dp,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, MaterialTheme.colors.primary.copy(0.5f)),
    ) {

        Column(Modifier.padding(6.dp)) {

            Text(
                text = "Capilary Refill Time :",
                style = MaterialTheme.typography.h6
            )

//            Spacer(spaceModifier)

            radioOptions.forEach { text ->
                Row(Modifier
                    .padding(bottom = 3.dp)
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
                        modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}




@Preview
@Composable
private fun TextFieldExamples() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopCenter)
    ) {
        var simpleText by remember { mutableStateOf("") }
        var basicText by remember { mutableStateOf("This is a Basic Textfield") }
        var emailText by remember { mutableStateOf("") }
        var phoneNumberText by remember { mutableStateOf("") }
        var passwordText by remember { mutableStateOf("") }
        var differentColorText by remember { mutableStateOf("") }
        var passwordVisibility: Boolean by remember { mutableStateOf(false) }
        var showError: Boolean by remember { mutableStateOf(false) }
        val focusManager = LocalFocusManager.current
//        val (simple, differentColor, email, phoneNumber, password) = remember { FocusRequester.createRefs() }
        val simple = remember { FocusRequester() }
        val differentColor = remember { FocusRequester() }
        val email = remember { FocusRequester() }
        val phoneNumber = remember { FocusRequester() }
        val password = remember { FocusRequester() }


        Spacer(modifier = Modifier.height(50.dp))

        // Basic Textfield which does not contain placeholder or any decorations
        BasicTextField(
            value = basicText,
            onValueChange = {
                basicText = it
            },
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .height(50.dp)
                .align(Alignment.CenterHorizontally)
                .padding(10.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { simple.requestFocus() })
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Simple textfield
        // With label and placeholder
        TextField(
            value = simpleText,
            onValueChange = { simpleText = it },
            label = { Text("Simple TextField") }, // It will be shown on the top when focussed
            placeholder = { Text("Placeholder text") }, // It will be shown as hint when nothing is typed
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
            ),
            isError = showError,
            modifier = Modifier.focusRequester(simple),
            keyboardActions = KeyboardActions(onNext = { differentColor.requestFocus() })
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Textfield with different coloured text input
        TextField(
            value = differentColorText,
            onValueChange = { differentColorText = it },
            label = { Text("TextField with Annotated text") },
            placeholder = { Text("PlaceHolder text") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
            ),
            visualTransformation = if (differentColorText == "") VisualTransformation.None else ColorsTransformation(),
            isError = showError,
            modifier = Modifier.focusRequester(differentColor),
            keyboardActions = KeyboardActions(onNext = { email.requestFocus() })
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Simple Outlined textfield
        // without placeholder
        OutlinedTextField(
            value = emailText,
            onValueChange = { emailText = it },
            label = { Text("Enter email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
            ),
            leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "") },
            isError = showError,
            modifier = Modifier.focusRequester(email),
            keyboardActions = KeyboardActions(onNext = { phoneNumber.requestFocus() })
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Phone number textfield with max length as 10
        OutlinedTextField(
            value = phoneNumberText,
            onValueChange = {
                if (it.length <= 10) phoneNumberText = it
            },
            label = { Text("Enter phonenumber") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone, imeAction = ImeAction.Next
            ),
            isError = showError,
            modifier = Modifier.focusRequester(phoneNumber),
            keyboardActions = KeyboardActions(onNext = { password.requestFocus() })
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Outlined Password textfield
        // Without label
         Spacer(modifier = Modifier.height(20.dp))

        Row {
            Button(
                onClick = {
                    showError = true
                },
                Modifier
                    .wrapContentSize(Alignment.Center)
                    .padding(5.dp)
            ) {
                Text(text = "Show Error")
            }
            Button(
                onClick = {
                    showError = false
                },
                Modifier
                    .wrapContentSize(Alignment.Center)
                    .padding(5.dp)
            ) {
                Text(text = "Remove Error")
            }
        }
    }

}


class ColorsTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            buildAnnotatedStringWithColors(text.toString()), OffsetMapping.Identity
        )
    }

    private fun buildAnnotatedStringWithColors(text: String): AnnotatedString {
        val words: List<String> = text.split("\\s+".toRegex())// splits by whitespace
        val colors = listOf(Color.Magenta, Color.Red, Color.Blue, Color.Black)
        var count = 0
        val builder = AnnotatedString.Builder()
        for (word in words) {
            builder.withStyle(style = SpanStyle(color = colors[count % 4])) {
                append("$word ")
            }
            count++
        }
        return builder.toAnnotatedString()
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
