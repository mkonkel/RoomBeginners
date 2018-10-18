package mkonkel.com.room.database.entity.book

import android.arch.persistence.room.*
import mkonkel.com.room.database.entity.user.User

@Entity(tableName = "books",
        foreignKeys = [ForeignKey(
                entity = User::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("user_id"),
                onDelete = ForeignKey.NO_ACTION
        ),
            ForeignKey(
                    entity = Category::class,
                    parentColumns = arrayOf("id"),
                    childColumns = arrayOf("category_id"),
                    onDelete = ForeignKey.NO_ACTION
            )
        ]
)
data class Book(
        @PrimaryKey(autoGenerate = true)
        var id: Long,

        @ColumnInfo(name = "user_id")
        var userId: Long?,

        @ColumnInfo(name = "category_id")
        var categoryId: Long?,

        var title: String?,

        @Embedded(prefix = "author_")
        var author: Author?

) {
    data class Author(
            var firstName: String,
            var lastName: String
    )
}