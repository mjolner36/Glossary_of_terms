package com.example.glossaryofterms

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.glossaryofterms.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.vocabulary_fragment,Vocabulary()).commit()

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.vocabulary -> {
                    supportFragmentManager.beginTransaction().replace(R.id.vocabulary_fragment,Vocabulary()).commit()
                    true
                }
                R.id.like  -> {
                   supportFragmentManager.beginTransaction().replace(R.id.vocabulary_fragment,Favorite()).commit()
                    true
                }
                else -> false
            }
        }
    }

}