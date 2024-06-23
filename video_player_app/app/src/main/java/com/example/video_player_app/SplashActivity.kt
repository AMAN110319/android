package com.example.video_player_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.video_player_app.databinding.SplashScreenBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: SplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Apply enter animation
        binding.imageViewLogo.startAnimation(android.view.animation.AnimationUtils.loadAnimation(this, R.anim.splash_enter))

        // Simulate long running operation (e.g., initializing app resources, checking user session)
        // Replace with your actual initialization logic
        simulateSplashScreen()
    }

    private fun simulateSplashScreen() {
        val splashDuration: Long = 2000 // 2 seconds delay

        Thread {
            try {
                Thread.sleep(splashDuration)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            } finally {
                runOnUiThread {
                    // Apply exit animation
                    binding.imageViewLogo.startAnimation(android.view.animation.AnimationUtils.loadAnimation(this@SplashActivity, R.anim.splash_exit))

                    // Start the main activity or any other desired activity after the splash screen
                    navigateToMainActivity()
                }
            }
        }.start()
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Prevent the user from coming back to the splash screen using back button
    }
}
