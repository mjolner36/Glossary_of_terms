package com.example.glossaryofterms

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent

class WebView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)


        val url = "https://www.google.com/"

        val customTabsIntent: CustomTabsIntent = CustomTabsIntent.Builder().setColorScheme(CustomTabsIntent.COLOR_SCHEME_DARK).build()
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }
}