package com.example.webviewandauth

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class WebViewActivity : AppCompatActivity() {

    private val navView: NavigationView by lazy { findViewById(R.id.navView) }
    private val drawer:DrawerLayout by lazy { findViewById(R.id.drawer) }
    private val wvWeb:WebView by lazy { findViewById(R.id.wvWeb) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        drawer.openDrawer(GravityCompat.START)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.google -> {
                    webViewStart(GOOGLE_URL)
                    toast("Google")
                }
                R.id.youtube -> {
                    webViewStart(YouTube_URL)
                    toast("YouTube")
                }
                R.id.stackoverflow -> {
                    webViewStart(StackOverFlow_URL)
                    toast("StackOverFlow")
                }
                R.id.github -> {
                    webViewStart(GITHUB_URL)
                    toast("Github")
                }
            }
            drawer.closeDrawer(GravityCompat.START)
            true
        }

    }

    fun toast(text:String){
        Toast.makeText(this@WebViewActivity, "Загружается сайт $text", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun webViewStart(url: String) {
        wvWeb.webViewClient = WebViewClient()

        wvWeb.apply {
            loadUrl(url)
            settings.javaScriptEnabled = true
            settings.loadWithOverviewMode = true
        }
    }

    override fun onBackPressed() {
        if (wvWeb.canGoBack()) wvWeb.goBack() else super.onBackPressed()
    }

}