package mkonkel.com.room.database.entity

import android.arch.persistence.room.*
import java.time.LocalDate

@Entity(tableName = "users")
@TypeConverters(UserStatusTypeConverter::class)
data class User(
        @PrimaryKey(autoGenerate = true)
        var id: Long,

        var firstName: String,

        var lastName: String,

        var fullName: String,

        var birthday: LocalDate?,

        @Embedded(prefix = "home_")
        var homeAddress: Address,

        @Embedded(prefix = "office_")
        var officeAddress: Address,

        @ColumnInfo(name = "email")
        var emailAddress: String,

        @ColumnInfo(name = "phone")
        var phoneNumber: String,

        var picture: String,

        var status: Status
) {

    data class Address(
            val street: String,
            val city: String,

            @ColumnInfo(name = "postalCode")
            val postal: String
    )

    enum class Status(val code: Int) {
        ACTIVE(0),
        PENDING(1),
        BLOCKED(3),
        UNKNOWN(-1)
    }
}

class UserStatusTypeConverter {
    @TypeConverter
    fun fromInteger(value: Int): User.Status {
        return when (value) {
            0 -> User.Status.ACTIVE
            1 -> User.Status.PENDING
            2 -> User.Status.BLOCKED
            else -> User.Status.UNKNOWN
        }
    }

    @TypeConverter
    fun statusToInteger(status: User.Status): Int {
        return status.code
    }
}