package mkonkel.com.room

import android.content.Context
import mkonkel.com.room.database.AppDatabase
import mkonkel.com.room.database.dao.UserDao

object Injector {

    fun provideUserDao(context: Context): UserDao {
        return AppDatabase.getInstance(context).userDao()
    }
}