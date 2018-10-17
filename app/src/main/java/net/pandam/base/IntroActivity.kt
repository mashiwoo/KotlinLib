package net.pandam.base

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.widget.FrameLayout
import android.widget.TextView

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_intro)
        supportActionBar?.hide()

        initialize()
    }

    fun initialize(){
        var introbackground = findViewById<FrameLayout>(R.id.intro_background)

        var introContent = findViewById<TextView>(R.id.intro_content)
        introContent.animate()

        //1
        val objectAnimator = ObjectAnimator.ofObject(
                introbackground,
                "backgroundColor",
                ArgbEvaluator(),
                ContextCompat.getColor(this, R.color.background_from),
                ContextCompat.getColor(this, R.color.background_to)
        )

        // 2
        objectAnimator.repeatCount = 1
        objectAnimator.repeatMode = ValueAnimator.REVERSE

        // 3
        objectAnimator.duration = 2000L
        objectAnimator.start()

        run.after(2000) { finish() }
    }

    class run {
        companion object {
            fun after(delay: Long, process: () -> Unit) {
                Handler().postDelayed({
                    process()
                }, delay)
            }
        }
    }
}
