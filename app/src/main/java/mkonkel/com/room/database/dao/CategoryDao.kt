package mkonkel.com.room.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import mkonkel.com.room.database.entity.book.Category

@Dao
interface CategoryDao {
    @Insert
    fun insertCategories(categories: List<Category>)
}