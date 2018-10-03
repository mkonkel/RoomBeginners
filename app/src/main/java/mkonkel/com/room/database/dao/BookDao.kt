package mkonkel.com.room.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import mkonkel.com.room.database.entity.book.Book
import mkonkel.com.room.database.entity.book.BookWithCategory

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(book: Book)

    @Insert
    fun insertBooks(users: List<Book>)

    @Query("SELECT * FROM books")
    fun books(): List<Book>

    @Query("SELECT * FROM books JOIN categories ON books.category_id = categories.id WHERE books.id = :bookID")
    fun getBookWithCategory(bookID: Long): BookWithCategory

    @Query("SELECT * FROM books JOIN categories ON books.category_id = categories.id")
    fun setBooksWithCategories(): List<BookWithCategory>
}