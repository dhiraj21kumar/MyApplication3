package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication3.R
import com.google.android.material.navigation.NavigationBarView
import com.example.myapplication3.HomeFragment
import com.example.myapplication3.ProfileFragment
import com.example.myapplication3.BookmarkFragment

class MainActivity : AppCompatActivity() {
    private var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottonNavigation)
//        supportFragmentManager.beginTransaction().replace(R.id.mainContainer, HomeFragment())
//            .commit()
//        bottomNavigationView.setSelectedItemId()
        with(bottomNavigationView) {
            this?.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
                var fragment: Fragment? = null
                when (item.itemId) {
                    R.id.nav_home -> fragment = HomeFragment()
                    R.id.nav_profile -> fragment = ProfileFragment()
                    R.id.nav_bookmark -> fragment = BookmarkFragment()
                }
                supportFragmentManager.beginTransaction().replace(R.id.mainContainer, fragment!!)
                    .commit()
                true
            })
        }
    }
}
