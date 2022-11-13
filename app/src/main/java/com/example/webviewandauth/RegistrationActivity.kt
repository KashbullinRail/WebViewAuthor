package com.example.webviewandauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegistrationActivity : AppCompatActivity() {

    private val etEmailReg:EditText by lazy { findViewById(R.id.etEmailReg) }
    private val etPasswordReg:EditText by lazy { findViewById(R.id.etPasswordReg) }
    private val btnRegistration:Button by lazy { findViewById(R.id.btnRegistration) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }
}