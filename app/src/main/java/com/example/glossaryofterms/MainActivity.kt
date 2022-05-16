package com.example.glossaryofterms

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.glossaryofterms.databinding.ActivityMainBinding


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