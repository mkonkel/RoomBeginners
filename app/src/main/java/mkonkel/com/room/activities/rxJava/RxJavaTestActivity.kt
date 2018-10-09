package mkonkel.com.room.activities.rxJava

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import mkonkel.com.room.R
import mkonkel.com.room.activities.liveData.LiveDataViewModel

class RxJavaTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java_test)

        ViewModelProviders.of(this).get(LiveDataViewModel::class.java)
    }
}
