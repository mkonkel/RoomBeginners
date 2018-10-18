package mkonkel.com.room.database.entity.book

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.TypeConverters

class BookWithCategory {
    @Embedded
    lateinit var book: Book

    @ColumnInfo(name = "name")
    @TypeConverters(CategoryNameTypeConverter::class)
    lateinit var category: Category.Name
}