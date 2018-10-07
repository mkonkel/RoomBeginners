package mkonkel.com.room.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import mkonkel.com.room.database.entity.classes.Subject
import mkonkel.com.room.database.entity.classes.UsersWithSubjects
import mkonkel.com.room.database.entity.user.User

@Dao
interface SubjectDao {
    @Insert
    fun insertSubjects(subjects: List<Subject>)

    @Insert
    fun insertUsersWithSubjects(data: List<UsersWithSubjects>)

    @Query("SELECT * FROM users INNER JOIN users_with_subjects AS uws ON uws.user_id = users.id INNER JOIN subjects ON subjects.id = uws.subject_id WHERE subjects.id = :subjectId")
    fun getUsersForGivenSubjects(subjectId: Long): List<User>
}