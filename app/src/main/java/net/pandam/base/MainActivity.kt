package net.pandam.base

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //초기화
        initialize()
    }

    fun initialize(){

        var btnIntro = findViewById<Button>(R.id.btn_intro)

        btnIntro.setOnClickListener {

            toast("인트로")

            val intent = Intent(applicationContext, IntroActivity::class.java)
            startActivity(intent)


        }
    }

    //toast 호출
    fun Context.toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
