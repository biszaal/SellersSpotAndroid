package com.biszaal.sellersspot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.fragment.app.FragmentContainer
import com.biszaal.sellersspot.Fragments.Account
import com.biszaal.sellersspot.Fragments.Friends
import com.biszaal.sellersspot.Fragments.Home
import com.biszaal.sellersspot.Fragments.Message
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity()
{
    private lateinit var tabBarView: BottomNavigationView
    private lateinit var tabBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabBarView = findViewById(R.id.tabBarView)

        tabBarView.background = null    // fixing weird background shadow
        tabBarView.menu.getItem(2).isEnabled = false    // disabling placeholder button that was set to align tab bar icons

        createTabBar()
    }

    private fun createTabBar()
    {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, Home())
            commit()
        }

        tabBarView.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.tab_home -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragment_container, Home())
                            commit()
                        }
                    }
                    R.id.tab_message -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragment_container, Message())
                            commit()
                        }
                    }
                    R.id.tab_friends -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragment_container, Friends())
                            commit()
                        }
                    }
                    R.id.tab_account -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragment_container, Account())
                            commit()
                        }
                    }
                    else -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragment_container, Home())
                            commit()
                        }
                    }

                }
                true
            })
    }
}
