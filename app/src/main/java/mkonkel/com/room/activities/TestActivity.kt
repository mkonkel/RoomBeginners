package mkonkel.com.room.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import mkonkel.com.room.Injector
import mkonkel.com.room.R

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val userDao = Injector.provideUserDao(this)
        val bookDao = Injector.provideBookDao(this)

        GlobalScope.launch {
            val user = userDao.getUserWithBooksById(0)

            val bookWithCategory = bookDao.getBookWithCategory(1)
//            val booksWithCategories = bookDao.setBooksWithCategories()

            Log.i("User:", "$user")

            Log.i("Book 1:", "${bookWithCategory.book} is ${bookWithCategory.category}")

//            booksWithCategories.forEach {
//                Log.i("book:", "${it.book} is ${it.category}")
//            }
        }
    }
}
