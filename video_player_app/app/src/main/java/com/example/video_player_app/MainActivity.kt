package com.example.video_player_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.video_player_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao=VideoDatabase.getDatabase(applicationContext).videoDao()
        val repository=VideoRepository(dao)
        mainViewModel=ViewModelProvider(this,MainViewModelFactory(repository,application)).get(MainViewModel::class.java)
        mainViewModel.getAllVideo().observe(this, Observer {})


        val firstFragment=FirstFragment()
        val favouriteFragment=FavouriteFragment()
        val listFragment=ListFragment()

        setCurrentFragment(listFragment)

        binding.bottomNavView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miHome-> setCurrentFragment(firstFragment)
                R.id.miList->setCurrentFragment(listFragment)
                R.id.miFavourites->setCurrentFragment(favouriteFragment)
            }
            true
        }
        mainViewModel.getAllVideo().observe(this,Observer<List<Video>>{

        })

    }


    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,fragment)
            commit()
        }
    }
}