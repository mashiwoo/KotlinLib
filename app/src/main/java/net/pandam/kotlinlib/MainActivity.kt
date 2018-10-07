package net.pandam.kotlinlib

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import net.pandam.kotlinlib.activity.ContentsActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WriteText("message")

        //INtent 이동
        var intent = Intent(this, ContentsActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun WriteText(message: String): String{
        return message
    }
}
