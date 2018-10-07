package mkonkel.com.room.database.entity.classes

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import mkonkel.com.room.database.entity.user.User

@Entity(tableName = "users_with_subjects",
        primaryKeys = ["user_id", "subject_id"],
        foreignKeys = [
            ForeignKey(
                    entity = User::class,
                    parentColumns = arrayOf("id"),
                    childColumns = arrayOf("user_id")
            ),
            ForeignKey(
                    entity = Subject::class,
                    parentColumns = arrayOf("id"),
                    childColumns = arrayOf("subject_id")
            )
        ]
)
data class UsersWithSubjects(
        @ColumnInfo(name = "user_id")
        var userId: Long,

        @ColumnInfo(name = "subject_id")
        var subjectId: Long
)