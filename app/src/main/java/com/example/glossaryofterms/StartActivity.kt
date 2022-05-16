package com.example.glossaryofterms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

    }
    fun openBetTerms(view: View){
        val intent:Intent = Intent(this@StartActivity,MainActivity::class.java)
        startActivity(intent)
    }
    fun openPolitics(view: View){
        view.isInvisible
        val intent:Intent = Intent(this@StartActivity,WebView::class.java)
        startActivity(intent)
    }

}