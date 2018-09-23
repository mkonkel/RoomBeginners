package mkonkel.com.room.database.dao

import android.arch.persistence.room.*
import mkonkel.com.room.database.entity.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Insert
    fun insertUsers(users: List<User>)

    @Update
    fun updateUser(user: User)

    @Update
    fun updateUsers(vararg users: User)

    @Delete
    fun deleteUser(user: User)

    @Delete
    fun deleteUsers(users: List<User>)

    @Query("SELECT * FROM users")
    fun users(): List<User>
}