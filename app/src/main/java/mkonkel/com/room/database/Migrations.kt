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

    val MIGRATION_2_3: Migration = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                    "CREATE TABLE 'books' ('id'  INTEGER NOT NULL, 'user_id' INTEGER, 'title' TEXT, 'author_firstName' TEXT, 'author_lastName' TEXT, FOREIGN KEY('user_id') REFERENCES users('id'), PRIMARY KEY('id'))"
            )
        }
    }

    val MIGRATION_3_4: Migration = object : Migration(3, 4) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                    "CREATE TABLE 'categories' ('id'  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 'name' INTEGER NOT NULL)")
            database.execSQL("INSERT INTO categories (name) VALUES (0),(1),(2),(3),(4),(5),(-1)")

            //Because of https://www.sqlite.org/omitted.html
            database.execSQL(
                    "CREATE TABLE 'books_new' ('id' INTEGER NOT NULL, 'user_id' INTEGER, 'category_id' INTEGER, 'title' TEXT, 'author_firstName' TEXT, 'author_lastName' TEXT, FOREIGN KEY('user_id') REFERENCES users('id'), FOREIGN KEY('category_id') REFERENCES categories('id'), PRIMARY KEY('id'))")
            database.execSQL(
                    "INSERT INTO books_new(id, user_id, category_id, title, author_firstName, author_lastName) SELECT id, user_id, 5, title, author_firstName, author_lastName FROM books")
            database.execSQL("DROP TABLE books")
            database.execSQL("ALTER TABLE books_new RENAME TO books")
        }
    }

    val MIGRATION_4_5: Migration = object : Migration(4, 5) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                    "CREATE TABLE 'subjects' ('id'  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 'name' STRING NOT NULL)")

            database.execSQL(
                    "CREATE TABLE 'users_with_subjects' ('user_id' INTEGER NOT NULL, 'subject_id' INTEGER NOT NULL, FOREIGN KEY('user_id') REFERENCES users('id'), FOREIGN KEY('subject_id') REFERENCES books('id'), PRIMARY KEY('user_id', 'subject_id'))"
            )
        }
    }
}