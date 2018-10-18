package mkonkel.com.room.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import mkonkel.com.room.Injector
import mkonkel.com.room.R
import mkonkel.com.room.database.entity.user.User

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val userDao = Injector.provideUserDao(this)
        val bookDao = Injector.provideBookDao(this)
        val abstractUserDao = Injector.provideAbstractUserDao(this)

        GlobalScope.launch {
            val user = userDao.getUserWithBooksById(1)
            val usersBooks = userDao.getUsersBooksSimple(1)
            val usersBooksTitles = userDao.getUsersBooksTitles(1)
            val subjectsForUser = userDao.getSubjectsForUser(1)
            val usersWithGivenParameters = userDao.getUsersByName("Mark", "Doe")

            val bookWithCategory = bookDao.getBookWithCategory(1)
            val booksWithCategories = bookDao.setBooksWithCategories()
            val booksWithCategoriesSimple = bookDao.setBooksWithCategoriesSimple()

            val users = abstractUserDao.getUsers()
            abstractUserDao.delete(users.first())
//            abstractUserDao.insert() //some user

            Log.d("TestActivity", "Queered")
        }
    }
}
