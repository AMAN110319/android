package com.example.viewpager2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val images = listOf(
            R.drawable.nature,
            R.drawable.nature2,
            R.drawable.nature3
        )

        val adapter=ViewPagerAdapter(images)
        binding.viewPager.adapter=adapter
//        binding.viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
//        binding.viewPager.beginFakeDrag()
//        binding.viewPager.fakeDragBy(-10f)
//        binding.viewPager.endFakeDrag()

        TabLayoutMediator(binding.tabs,binding.viewPager){
            tab,pos-> tab.text = "Tab  ${pos+1}"
        }.attach()

           }
}