package dev.ebrahim.premierleague

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper


class SplashActivity : AppCompatActivity() {
    val SPLASH_DELAY: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        // Delay the splash screen for 3 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            // Start the main activity here
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Finish the splash activity
            finish()
        }, SPLASH_DELAY)
    }
}
