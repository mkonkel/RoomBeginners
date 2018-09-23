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

        GlobalScope.launch {
            val users = userDao.users()

            users.forEach {
                Log.d("User", "$it")
            }
        }
    }
}
