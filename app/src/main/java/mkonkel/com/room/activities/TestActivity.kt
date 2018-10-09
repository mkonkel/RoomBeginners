package mkonkel.com.room.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import mkonkel.com.room.Injector
import mkonkel.com.room.R
import mkonkel.com.room.activities.liveData.LiveDataTestActivity
import mkonkel.com.room.activities.rxJava.RxJavaTestActivity
import mkonkel.com.room.database.dao.BookDao
import mkonkel.com.room.database.dao.SubjectDao
import mkonkel.com.room.database.dao.UserDao
import timber.log.Timber

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val userDao = Injector.provideUserDao(this)
        val bookDao = Injector.provideBookDao(this)
        val subjectDao = Injector.provideSubjectDao(this)

        GlobalScope.launch {
            runAllUserDao(userDao)
            runAllBookDao(bookDao)
            runAllSubjectDao(subjectDao)
        }

        val liveData: Button = findViewById(R.id.btn_live_data)
        val rxJava: Button = findViewById(R.id.btn_rx_java)

        liveData.setOnClickListener {
            startActivity(Intent(this, LiveDataTestActivity::class.java))
        }

        rxJava.setOnClickListener {
            startActivity(Intent(this, RxJavaTestActivity::class.java))
        }
    }

    private fun runAllUserDao(userDao: UserDao) {
        Timber.i("---- Users ----")
        val users = userDao.users()
        users.forEach {
            Timber.i("$it")
        }

        Timber.i("---- User with Books - userId: 1 ----")
        val userWithBooks = userDao.getUserWithBooksById(1)
        Timber.i("${userWithBooks.user}")
        userWithBooks.books.forEach {
            Timber.i("$it")
        }

        Timber.i("---- Users Books Titles -userId: 1 ----")
        val usersBooksTitles = userDao.getUsersBooksTitles(1)
        Timber.i("${usersBooksTitles.user}")
        usersBooksTitles.bookkTitle.forEach {
            Timber.i(it)
        }

        Timber.i("---- User By Name or LastName ----")
        val usersByName = userDao.getUsersByName("John", "Smith")
        usersByName.forEach {
            Timber.i("$it")
        }

        Timber.i("---- Subjects For User - userId: 1 ----")
        val subjectsForUser = userDao.getSubjectsForUser(1)
        Timber.i("$subjectsForUser")

        Timber.i("---- Users Books Simple - userId: 1 ----")
        val usersBooksSimple = userDao.getUsersBooksSimple(1)
        usersBooksSimple.forEach {
            Timber.i("$it")
        }
    }

    private fun runAllBookDao(bookDao: BookDao) {
        Timber.i("---- Books ----")
        val books = bookDao.books()
        books.forEach {
            Timber.i("$it")
        }

        Timber.i("---- Book with Category - bookId: 1----")
        val bookWithCategory = bookDao.getBookWithCategory(1)
        Timber.i("$bookWithCategory")

        Timber.i("---- Books with Category ----")
        val booksWithCategories = bookDao.getBooksWithCategories()
        booksWithCategories.forEach {
            Timber.i("${it.book}, ${it.category}")
        }

        Timber.i("---- Books with Categories Simple ----")
        val booksWithCategoriesSimple = bookDao.getBooksWithCategoriesSimple()
        booksWithCategoriesSimple.forEach {
            Timber.i("${it.book}, ${it.category}")
        }
    }

    private fun runAllSubjectDao(subjectDao: SubjectDao) {
        Timber.i("---- Users For Given Subject - subjectId: 1 ----")
        val usersForGivenSubject = subjectDao.getUsersForGivenSubjects(1)
        usersForGivenSubject.forEach {
            Timber.i("$it")
        }
    }
}
