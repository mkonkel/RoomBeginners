package mkonkel.com.room.activities.liveData

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import mkonkel.com.room.Injector
import mkonkel.com.room.database.dao.UserDao
import mkonkel.com.room.database.entity.user.User

class LiveDataViewModel(application: Application) : AndroidViewModel(application) {
    private var userDao: UserDao = Injector.provideUserDao(application)

    fun getUser(userId: Long): LiveData<User> {
        return userDao.userLiveData(userId)
    }

    fun editUser(user: User) {
        GlobalScope.launch {
            val name = if (user.firstName == "Richard") "John" else "Richard"
            userDao.updateUser(
                    user.apply {
                        firstName = name
                    }
            )
        }
    }
}