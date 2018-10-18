package mkonkel.com.room.database.data

import mkonkel.com.room.database.entity.book.Book
import mkonkel.com.room.database.entity.book.Category
import mkonkel.com.room.database.entity.classes.Subject
import mkonkel.com.room.database.entity.classes.UsersWithSubjects
import mkonkel.com.room.database.entity.user.User
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
            ),
            User(
                    id = 0,
                    firstName = "Dan",
                    lastName = "Crafter",
                    fullName = "Dan Crafter",
                    birthday = LocalDate.parse("1979-11-21"),
                    emailAddress = "craftit@mail.com",
                    phoneNumber = "001666999666",
                    picture = "/pictures/dcrafter/avatar/picture_as.png",
                    homeAddress = User.Address(
                            street = "Down Street",
                            city = "Salt Lake City",
                            postal = "31701"
                    ),
                    officeAddress = User.Address(
                            street = "Harbor Av",
                            city = "Salt Lake City",
                            postal = "31704"
                    ),
                    status = User.Status.BLOCKED
            )
    )

    val books = listOf(
            Book(
                    id = 0,
                    title = "First Book",
                    author = Book.Author(
                            firstName = "Adam",
                            lastName = "Doe"
                    ),
                    userId = null,
                    categoryId = 1
            ),
            Book(
                    id = 0,
                    title = "Second Book",
                    author = Book.Author(
                            firstName = "Alice",
                            lastName = "Kowalsky"
                    ),
                    userId = 1,
                    categoryId = 2
            ),
            Book(
                    id = 0,
                    title = "Second Book",
                    author = Book.Author(
                            firstName = "Alice",
                            lastName = "Kowalsky"
                    ),
                    userId = 1,
                    categoryId = 2
            ),
            Book(
                    id = 0,
                    title = "Third Book",
                    author = Book.Author(
                            firstName = "Alice",
                            lastName = "Kowalsky"
                    ),
                    userId = 1,
                    categoryId = 2
            ),
            Book(
                    id = 0,
                    title = "Fourth Book",
                    author = Book.Author(
                            firstName = "Alice",
                            lastName = "Kowalsky"
                    ),
                    userId = 2,
                    categoryId = 2
            ),
            Book(
                    id = 0,
                    title = "Fifth Book",
                    author = Book.Author(
                            firstName = "Alice",
                            lastName = "Kowalsky"
                    ),
                    userId = 2,
                    categoryId = 2
            )
    )

    val categories = listOf(
            Category(id = 0, name = Category.Name.SCIENCE),
            Category(id = 0, name = Category.Name.ROMANCE),
            Category(id = 0, name = Category.Name.FANTASY),
            Category(id = 0, name = Category.Name.DRAMA),
            Category(id = 0, name = Category.Name.COMEDY),
            Category(id = 0, name = Category.Name.UNKNOWN)
    )

    val subjects = listOf(
            Subject(0, "Art"),
            Subject(0, "Biology"),
            Subject(0, "Chemistry"),
            Subject(0, "English"),
            Subject(0, "Geography"),
            Subject(0, "Mathematics"),
            Subject(0, "PE"),
            Subject(0, "Science")
    )

    val users_with_subjects = listOf(
            UsersWithSubjects(1, 1),
            UsersWithSubjects(1, 2),
            UsersWithSubjects(1, 3),
            UsersWithSubjects(1, 4),
            UsersWithSubjects(1, 5),
            UsersWithSubjects(1, 6),
            UsersWithSubjects(1, 7),
            UsersWithSubjects(1, 8),
            UsersWithSubjects(2, 1),
            UsersWithSubjects(2, 2),
            UsersWithSubjects(2, 3),
            UsersWithSubjects(2, 4),
            UsersWithSubjects(2, 5)
    )
}