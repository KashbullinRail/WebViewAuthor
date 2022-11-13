package com.example.webviewandauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class WebViewActivity : AppCompatActivity() {

    private val navView: NavigationView by lazy { findViewById(R.id.navView) }
    private val drawer:DrawerLayout by lazy { findViewById(R.id.drawer) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        drawer.openDrawer(GravityCompat.START)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.google -> {
                    toast("Google")
                }
                R.id.youtube -> {
                    toast("YouTube")
                }
                R.id.stackoverflow -> {
                    toast("StackOverFlow")
                }
                R.id.github -> {
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

}