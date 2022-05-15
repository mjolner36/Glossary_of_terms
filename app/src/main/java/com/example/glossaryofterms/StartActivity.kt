package com.example.glossaryofterms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

    }
    fun openBetTerms(view: View){
        val intent:Intent = Intent(this@StartActivity,MainActivity::class.java)
        startActivity(intent)
    }
}