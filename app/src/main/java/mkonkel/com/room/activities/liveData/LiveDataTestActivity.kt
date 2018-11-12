package mkonkel.com.room.activities.liveData

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import formatToString
import mkonkel.com.room.R
import mkonkel.com.room.database.entity.user.User

class LiveDataTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_test)

        val userContent: TextView = findViewById(R.id.user_content)
        val changeNameBtn: Button = findViewById(R.id.btn_change_name)

        var user: User? = null

        val model = ViewModelProviders.of(this).get(LiveDataViewModel::class.java)
        model.getUser(1).observe(this, Observer {
            user= it

            it?.let {
                userContent.text = user.formatToString()
            }
        })

        changeNameBtn.setOnClickListener {
            user?.let {
                model.editUser(it)
            }
        }
    }
}
