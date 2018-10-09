package mkonkel.com.room.activities.liveData

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import mkonkel.com.room.R
import timber.log.Timber

class LiveDataTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_test)

        val model = ViewModelProviders.of(this).get(LiveDataViewModel::class.java)
        model.getUser(1).observe(this, Observer { user ->
            Timber.i("$user")
        })
    }
}
