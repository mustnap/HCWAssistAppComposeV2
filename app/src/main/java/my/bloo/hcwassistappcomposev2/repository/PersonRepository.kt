package my.bloo.hcwassistappcomposev2.repository

import my.bloo.hcwassistappcomposev2.model.Person

class PersonRepository {
    fun getAllData(): List<Person> {
        return listOf(
            Person(
                id = 0,
                firstName = "John",
                lastName = "Doe",
                dateOfBirth = "2022-01-01",
                age = 4
            ),
            Person(
                id = 1,
                firstName = "Maria",
                lastName = "Garcia",
                dateOfBirth = "2022-01-01",
                age = 7
            ),
            Person(
                id = 2,
                firstName = "James",
                lastName = "Johnson",
                dateOfBirth = "2022-01-01",
                age = 2
            ),
            Person(
                id = 3,
                firstName = "Michael",
                lastName = "Brown",
                dateOfBirth = "2022-01-01",
                age = 10
            ),
            Person(
                id = 4,
                firstName = "Robert",
                lastName = "Davis",
                dateOfBirth = "2022-01-01",
                age = 5
            ),
            Person(
                id = 5,
                firstName = "Jenifer",
                lastName = "Miller",
                dateOfBirth = "2022-01-01",
                age = 3
            ),
            Person(
                id = 6,
                firstName = "Sarah",
                lastName = "Lopez",
                dateOfBirth = "2022-01-01",
                age = 1
            ),
            Person(
                id = 7,
                firstName = "Charles",
                lastName = "Wilson",
                dateOfBirth = "2022-01-01",
                age = 0
            ),
            Person(
                id = 8,
                firstName = "Daniel",
                lastName = "Taylor",
                dateOfBirth = "2022-01-01",
                age = 2
            ),
            Person(
                id = 9,
                firstName = "Mark",
                lastName = "Lee",
                dateOfBirth = "2022-01-01",
                age = 8
            ),
            Person(
                id = 10,
                firstName = "Baby",
                lastName = "Boo",
                dateOfBirth = "2022-01-01",
                age = 12
            ),
        )
    }
}
