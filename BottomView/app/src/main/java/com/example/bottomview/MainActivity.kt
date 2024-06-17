package com.example.bottomview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bottomview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment= ThirdFragment()

        setCurrentFragment(firstFragment)

        binding.bottomNavView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miHome->setCurrentFragment(firstFragment)
                R.id.miMessages->setCurrentFragment(secondFragment)
                R.id.miProfile->setCurrentFragment(thirdFragment)
            }
            true
        }

        binding.bottomNavView.getOrCreateBadge(R.id.miMessages).apply {
            number=10
            isVisible=true
        }
    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,fragment)
            commit()
        }
    }
}