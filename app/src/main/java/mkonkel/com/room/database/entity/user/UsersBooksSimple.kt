package mkonkel.com.room.database.entity.user

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.TypeConverters
import mkonkel.com.room.database.entity.book.Category
import mkonkel.com.room.database.entity.book.CategoryNameTypeConverter

class UsersBooksSimple {
    @ColumnInfo(name = "title")
    lateinit var name: String

    lateinit var author: String

    @TypeConverters(CategoryNameTypeConverter::class)
    lateinit var category: Category.Name
}