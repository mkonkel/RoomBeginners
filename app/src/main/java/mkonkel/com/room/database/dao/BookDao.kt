package mkonkel.com.room.database.dao

import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import mkonkel.com.room.database.entity.Book

interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(book: Book)

    @Insert
    fun insertBooks(users: List<Book>)
}