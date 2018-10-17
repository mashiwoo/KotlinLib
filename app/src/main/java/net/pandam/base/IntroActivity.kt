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
        var intro_background = findViewById<FrameLayout>(R.id.intro_background)

        var intro_content = findViewById<TextView>(R.id.intro_content)
        intro_content.animate()

        //1
        val object_animator = ObjectAnimator.ofObject(
                intro_background,
                "backgroundColor",
                ArgbEvaluator(),
                ContextCompat.getColor(this, R.color.background_from),
                ContextCompat.getColor(this, R.color.background_to)
        )

        // 2
        object_animator.repeatCount = 1
        object_animator.repeatMode = ValueAnimator.REVERSE

        // 3
        object_animator.duration = IntroActivity.Companion.DEFAULT_ANIMATION_DURATION
        object_animator.start()

        run.after(2000, { finish() })
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

    companion object {
        val DEFAULT_ANIMATION_DURATION = 2000L
    }
}
