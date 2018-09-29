package mkonkel.com.room.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration

object Migrations {

    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE `users` ADD COLUMN birthday TEXT")
            database.execSQL("ALTER TABLE `users` ADD COLUMN home_street TEXT")
            database.execSQL("ALTER TABLE `users` ADD COLUMN home_city TEXT")
            database.execSQL("ALTER TABLE `users` ADD COLUMN home_postalCode TEXT")
            database.execSQL("ALTER TABLE `users` ADD COLUMN office_street TEXT")
            database.execSQL("ALTER TABLE `users` ADD COLUMN office_city TEXT")
            database.execSQL("ALTER TABLE `users` ADD COLUMN office_postalCode TEXT")
            database.execSQL("ALTER TABLE `users` ADD COLUMN status INTEGER NOT NULL DEFAULT -1")
        }
    }
}