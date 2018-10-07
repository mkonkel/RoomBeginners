package mkonkel.com.room.database.dao

import android.arch.persistence.room.*
import mkonkel.com.room.database.entity.classes.Subject
import mkonkel.com.room.database.entity.user.User
import mkonkel.com.room.database.entity.user.UserWithAllBooks

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

    @Transaction
    @Query("SELECT * FROM users WHERE id = :userId LIMIT 1")
    fun getUserWithBooksById(userId: Long): UserWithAllBooks

    @Query("SELECT * FROM subjects INNER JOIN users_with_subjects AS uws ON uws.subject_id = subjects.id INNER JOIN users ON users.id = uws.user_id WHERE users.id = :userId")
    fun getSubjectsForUser(userId: Long): List<Subject>
}