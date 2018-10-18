package mkonkel.com.room.database.dao.abstract

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert

interface BaseDao<T> {
    @Insert
    fun insert(obj: T)

    @Delete
    fun delete(obj: T)
}