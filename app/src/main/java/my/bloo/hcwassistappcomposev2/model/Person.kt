package my.bloo.hcwassistappcomposev2.model

import java.time.LocalDate

data class Person(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: String,
    val age: Int
)
