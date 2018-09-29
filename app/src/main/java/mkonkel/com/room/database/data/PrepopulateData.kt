package mkonkel.com.room.database.data

import mkonkel.com.room.database.entity.User
import java.time.LocalDate


object PrepopulateData {
    val users = listOf(
            User(
                    id = 0,
                    firstName = "John",
                    lastName = "Doe",
                    fullName = "John Doe",
                    birthday = LocalDate.parse("1980-01-01"),
                    emailAddress = "jdoe@mail.com",
                    phoneNumber = "001333444555",
                    picture = "/pictures/jdoe/avatar/s34trag_732_jkdal.png",
                    homeAddress = User.Address(
                            street = "Washington Street",
                            city = "Arkansas",
                            postal = "72701"
                    ),
                    officeAddress = User.Address(
                            street = "4th Street",
                            city = "Arkansas",
                            postal = "72749"
                    ),
                    status = User.Status.ACTIVE
            ),
            User(
                    id = 0,
                    firstName = "Mark",
                    lastName = "Smith",
                    fullName = "Mark Smith",
                    birthday = LocalDate.parse("1990-01-01"),
                    emailAddress = "mastermike@mail.com",
                    phoneNumber = "001666999888",
                    picture = "/pictures/msmith/avatar/123454647_gfas.png",
                    homeAddress = User.Address(
                            street = "Main Street",
                            city = "Arkansas",
                            postal = "72701"
                    ),
                    officeAddress = User.Address(
                            street = "4th Street",
                            city = "Arkansas",
                            postal = "72749"
                    ),
                    status = User.Status.BLOCKED
            )
    )
}