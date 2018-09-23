package mkonkel.com.room.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class User(
        @PrimaryKey(autoGenerate = true)
        var id: Long,

        var firstName: String,

        var lastName: String,

        var fullName: String,

        @ColumnInfo(name = "email")
        var emailAddress: String,

        @ColumnInfo(name = "phone")
        var phoneNumber: String,

        var picture: String
)