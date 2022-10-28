package my.bloo.hcwassistappcomposev2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import my.bloo.hcwassistappcomposev2.graphs.Graph
import my.bloo.hcwassistappcomposev2.model.Person
import my.bloo.hcwassistappcomposev2.ui.theme.Typography


@Composable
fun CustomItem(person: Person, onSignUpClick: () -> Unit) {
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .clickable { onSignUpClick()  }
            .fillMaxWidth()
            .padding(16.dp)
            .clip(shape = RoundedCornerShape(3.dp))
            .background(color = Color.White),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Patient ID: ",
            color = Color.Black,
            fontSize = Typography.h5.fontSize,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = "${person.id}",
            color = Color.Black,
            fontSize = Typography.h4.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Age: ",
            color = Color.Black,
            fontSize = Typography.h5.fontSize,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = "${person.age}",
            color = Color.Black,
            fontSize = Typography.h4.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
@Preview
fun CustomItemPreview() {
    CustomItem(
        person = Person(
            id = 0,
            firstName = "John",
            lastName = "Doe",
            dateOfBirth = "2020-01-01",
            age = 20
        ) , {}
    )
}
