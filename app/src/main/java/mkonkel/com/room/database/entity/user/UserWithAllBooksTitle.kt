package mkonkel.com.room.database.entity.user

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation
import mkonkel.com.room.database.entity.book.Book

class UserWithAllBooksTitle {
    @Embedded
    lateinit var user: User

    @Relation(parentColumn = "id", entityColumn = "user_id", entity = Book::class, projection = ["title"])
    lateinit var bookkTitle: List<String>
}