package mkonkel.com.room.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import mkonkel.com.room.database.converter.DateTypeConverter
import mkonkel.com.room.database.dao.BookDao
import mkonkel.com.room.database.dao.UserDao
import mkonkel.com.room.database.data.PrepopulateData
import mkonkel.com.room.database.entity.book.Book
import mkonkel.com.room.database.entity.book.Category
import mkonkel.com.room.database.entity.user.User

@Database(
        entities = [Book::class, User::class, Category::class],
        version = AppDatabase.DB_VERSION
)
@TypeConverters(DateTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun bookDao(): BookDao

    companion object {
        const val DB_VERSION = 4
        const val DB_NAME = "application.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context)
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                        .addCallback(dbCreateCallback(context))
                        .addMigrations(Migrations.MIGRATION_1_2)
                        .addMigrations(Migrations.MIGRATION_2_3)
                        .addMigrations(Migrations.MIGRATION_3_4)
                        .build()

        private fun dbCreateCallback(context: Context) = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                GlobalScope.launch {
                    val instance = getInstance(context)
                    instance.userDao().insertUsers(PrepopulateData.users)
                    instance.bookDao().insertBooks(PrepopulateData.books)
                }
            }
        }
    }
}