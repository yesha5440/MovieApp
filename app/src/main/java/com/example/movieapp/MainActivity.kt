package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.movieapp.Fragment.NowPlayingFragment
import com.example.movieapp.Fragment.PopularFragment
import com.example.movieapp.Fragment.TopFragment
import com.example.movieapp.Fragment.UpcomingFragment
import com.example.movieapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.reflect.Type


private val ActivityMainBinding.bottomnav: Any
    get() {
        TODO("Not yet implemented")
    }

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var Type = arrayOf("Now Playing","Popular","Top","Up Coming")
        var Fragment = arrayOf(NowPlayingFragment(),PopularFragment(),TopFragment(),UpcomingFragment())
        loadFragment(NowPlayingFragment())
        binding.bottomnav.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemReselectedListener{

            override fun onNavigationItemReselected(item: MenuItem): Boolean {

                when (item.itemId){
                    R.id.nowplaying -> {
                        loadFragment(NowPlayingFragment())
                    }
                }

                when (item.itemId){
                    R.id.popular -> {
                        loadFragment(PopularFragment())
                    }
                }

                when (item.itemId){
                    R.id.top -> {
                        loadFragment(TopFragment())
                    }
                }

                when (item.itemId){
                    R.id.upcoming -> {
                        loadFragment(UpcomingFragment())
                    }
                }

                return true

            }

        })

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.Frame,fragment)
            .commit()
    }
}

private fun Any.setOnNavigationItemSelectedListener(onNavigationItemReselectedListener: BottomNavigationView.OnNavigationItemReselectedListener) {

}
