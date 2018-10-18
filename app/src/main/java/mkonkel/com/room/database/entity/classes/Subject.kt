package mkonkel.com.room.database.entity.classes

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "subjects")
data class Subject(
        @PrimaryKey(autoGenerate = true)
        var id: Long,

        var name: String
)