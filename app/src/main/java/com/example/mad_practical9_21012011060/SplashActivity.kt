package com.example.mad_practical9_21012011060

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {

    lateinit var imageanimation: AnimationDrawable
    lateinit var logoimage: ImageView
    lateinit var logoanimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        logoimage = findViewById(R.id.uvpce)
        logoimage.setBackgroundResource(R.drawable.guni_logo)
        imageanimation = logoimage.background as AnimationDrawable
        logoanimation = AnimationUtils.loadAnimation(this, R.anim.tweenanim)
        logoanimation.setAnimationListener(this) // Set animation listener
        logoimage.startAnimation(logoanimation)
    }

    override fun onAnimationStart(animation: Animation?) {}

    override fun onAnimationEnd(animation: Animation?) {
        // Start the MainActivity when the animation ends
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Finish the SplashActivity
    }

    override fun onAnimationRepeat(animation: Animation?) {}

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            imageanimation.start()
            logoimage.startAnimation(logoanimation)
        } else {
            imageanimation.stop()
        }
    }
}
