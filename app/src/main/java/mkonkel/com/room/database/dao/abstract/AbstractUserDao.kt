package mkonkel.com.room.database.dao.abstract

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import mkonkel.com.room.database.entity.user.User

@Dao
abstract class AbstractUserDao : BaseDao<User> {
    @Query("SELECT * FROM users")
    abstract fun getUsers(): List<User>
}