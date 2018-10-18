package mkonkel.com.room.database.entity.book

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.TypeConverters

class BookWithCategorySimple {
    @Embedded
    lateinit var book: Book

    @TypeConverters(CategoryNameTypeConverter::class)
    lateinit var category: Category.Name
}