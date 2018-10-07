package mkonkel.com.room.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import mkonkel.com.room.database.entity.classes.Subject
import mkonkel.com.room.database.entity.classes.UsersWithSubjects

@Dao
interface SubjectDao {
    @Insert
    fun insertSubjects(subjects: List<Subject>)

    @Insert
    fun insertUsersWithSubjects(data: List<UsersWithSubjects>)
}