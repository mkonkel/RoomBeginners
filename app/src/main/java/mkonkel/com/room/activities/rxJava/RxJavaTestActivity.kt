package mkonkel.com.room.activities.rxJava

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import formatToString
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import mkonkel.com.room.Injector
import mkonkel.com.room.R
import mkonkel.com.room.database.entity.user.User
import timber.log.Timber

class RxJavaTestActivity : AppCompatActivity() {
    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java_test)

        val userDao = Injector.provideUserDao(this)
        val userContent: TextView = findViewById(R.id.user_content)
        val changeNameBtn: Button = findViewById(R.id.btn_change_name)

        var user: User? = null

        userDao.userRx(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    Timber.i("$it")
                    user = it
                    userContent.text = it.formatToString()
                }
                .subscribe()
                .addTo(disposable)

        changeNameBtn.setOnClickListener {
            user?.let {
                GlobalScope.launch {
                    val name = if (it.firstName == "Richard") "John" else "Richard"
                    userDao.updateUser(
                            it.apply {
                                firstName = name
                            }
                    )
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }
}
