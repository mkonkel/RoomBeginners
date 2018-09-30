package mkonkel.com.room.database.entity

import android.arch.persistence.room.*

@Entity(tableName = "books",
        foreignKeys = [ForeignKey(
                entity = User::class,
                parentColumns = ["id"],
                childColumns = ["user_id"],
                onDelete = ForeignKey.NO_ACTION
        )]
)
data class Book(
        @PrimaryKey(autoGenerate = true)
        var id: Long,

        @ColumnInfo(name = "user_id")
        var userId: Long?,

        var title: String?,

        @Embedded(prefix = "author_")
        var author: Author?

) {
    data class Author(
            var firstName: String,
            var lastName: String
    )
}