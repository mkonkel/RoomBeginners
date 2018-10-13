package mkonkel.com.room.database.user

import mkonkel.com.room.database.entity.user.User
import java.time.LocalDate

object UserData {
    fun createUserWithIndex(index: Long) = User(
            id = index,
            firstName = "Test",
            lastName = "User",
            fullName = "Test User $index",
//            nickName = "nick$index",
            birthday = LocalDate.parse("198$index-10-10"),
            homeAddress = User.Address(
                    street = "Street",
                    city = "City",
                    postal = "64-666-$index"
            ),
            officeAddress = User.Address(
                    street = "Another Street",
                    city = "City",
                    postal = "64-666"
            ),
            phoneNumber = "000-111-222-333-$index",
            emailAddress = "random@userLiveData.for.test",
            picture = "avatar.jpg",
            status = User.Status.ACTIVE
    )
}