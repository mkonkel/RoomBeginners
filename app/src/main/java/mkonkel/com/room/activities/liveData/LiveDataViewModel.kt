package mkonkel.com.room.activities.liveData

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import mkonkel.com.room.Injector
import mkonkel.com.room.database.dao.UserDao
import mkonkel.com.room.database.entity.user.User

class LiveDataViewModel(application: Application) : AndroidViewModel(application) {
    var userDao: UserDao = Injector.provideUserDao(application)

    fun getUser(userId: Long): LiveData<User> {
        return userDao.user(userId)
    }
}