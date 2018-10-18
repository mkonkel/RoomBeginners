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
import mkonkel.com.room.database.dao.SubjectDao
import mkonkel.com.room.database.dao.CategoryDao
import mkonkel.com.room.database.dao.UserDao
import mkonkel.com.room.database.dao.abstract.AbstractUserDao
import mkonkel.com.room.database.data.PrepopulateData
import mkonkel.com.room.database.entity.book.Book
import mkonkel.com.room.database.entity.book.Category
import mkonkel.com.room.database.entity.classes.Subject
import mkonkel.com.room.database.entity.classes.UsersWithSubjects
import mkonkel.com.room.database.entity.user.User

@Database(
        entities = [Book::class, User::class, Category::class, Subject::class, UsersWithSubjects::class],
        version = AppDatabase.DB_VERSION
)
@TypeConverters(DateTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun bookDao(): BookDao
    abstract fun categoriesDao(): CategoryDao
    abstract fun subjectDao(): SubjectDao
    abstract fun abstractUserDao(): AbstractUserDao

    companion object {
        const val DB_VERSION = 5
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
                        .addMigrations(Migrations.MIGRATION_4_5)
                        .build()

        private fun dbCreateCallback(context: Context) = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                GlobalScope.launch {
                    val instance = getInstance(context)
                    instance.categoriesDao().insertCategories(PrepopulateData.categories)
                    instance.userDao().insertUsers(PrepopulateData.users)
                    instance.bookDao().insertBooks(PrepopulateData.books)
                    instance.subjectDao().insertSubjects(PrepopulateData.subjects)
                    instance.subjectDao().insertUsersWithSubjects(PrepopulateData.users_with_subjects)
                }
            }
        }
    }
}