package mkonkel.com.room.database.entity.book

import android.arch.persistence.room.*

@Entity(tableName = "categories")
@TypeConverters(CategoryNameTypeConverter::class)
data class Category(
        @PrimaryKey(autoGenerate = true)
        var id: Long,

        var name: Name
) {
    enum class Name(val code: Int) {
        COMEDY(0),
        DRAMA(1),
        FANTASY(2),
        ROMANCE(3),
        SCIENCE(4),
        UNKNOWN(-1)
    }
}

class CategoryNameTypeConverter {
    @TypeConverter
    fun fromInteger(value: Int): Category.Name {
        return when (value) {
            0 -> Category.Name.COMEDY
            1 -> Category.Name.DRAMA
            2 -> Category.Name.FANTASY
            3 -> Category.Name.ROMANCE
            4 -> Category.Name.SCIENCE
            else -> Category.Name.UNKNOWN
        }
    }

    @TypeConverter
    fun statusToInteger(category: Category.Name): Int {
        return category.code
    }
}