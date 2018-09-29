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
import mkonkel.com.room.database.dao.UserDao
import mkonkel.com.room.database.data.PrepopulateData
import mkonkel.com.room.database.entity.User

@Database(
        entities = [User::class],
        version = AppDatabase.DB_VERSION
)
@TypeConverters(DateTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        const val DB_VERSION = 1
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
                        .build()

        private fun dbCreateCallback(context: Context) = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                GlobalScope.launch {
                    getInstance(context).userDao()
                            .insertUsers(PrepopulateData.users)
                }
            }
        }
    }
}