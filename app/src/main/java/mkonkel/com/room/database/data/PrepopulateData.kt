package mkonkel.com.room.database.data

import mkonkel.com.room.database.entity.User

object PrepopulateData {
    val users = listOf(
            User(
                    id = 0,
                    firstName = "John",
                    lastName = "Doe",
                    fullName = "John Doe",
                    emailAddress = "jdoe@mail.com",
                    phoneNumber = "001333444555",
                    picture = "/pictures/jdoe/avatar/s34trag_732_jkdal.png"
            ),
            User(
                    id = 0,
                    firstName = "Mark",
                    lastName = "Smith",
                    fullName = "Mark Smith",
                    emailAddress = "mastermike@mail.com",
                    phoneNumber = "001666999888",
                    picture = "/pictures/msmith/avatar/123454647_gfas.png"
            )
    )
}