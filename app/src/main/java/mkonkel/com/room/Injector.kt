package mkonkel.com.room

import android.content.Context
import mkonkel.com.room.database.AppDatabase
import mkonkel.com.room.database.dao.BookDao
import mkonkel.com.room.database.dao.SubjectDao
import mkonkel.com.room.database.dao.UserDao
import mkonkel.com.room.database.dao.abstract.AbstractUserDao

object Injector {

    fun provideUserDao(context: Context): UserDao {
        return AppDatabase.getInstance(context).userDao()
    }

    fun provideBookDao(context: Context): BookDao {
        return AppDatabase.getInstance(context).bookDao()
    }

    fun provideSubjectDao(context: Context): SubjectDao {
        return AppDatabase.getInstance(context).subjectDao()
    }

    fun provideAbstractUserDao(context: Context): AbstractUserDao {
        return AppDatabase.getInstance(context).abstractUserDao()
    }
}