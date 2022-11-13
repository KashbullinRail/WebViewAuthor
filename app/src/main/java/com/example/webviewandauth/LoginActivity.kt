package com.example.webviewandauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private val etEmail: EditText by lazy { findViewById(R.id.etEmail) }
    private val etPassword: EditText by lazy { findViewById(R.id.etPassword) }
    private val btnLogin: Button by lazy { findViewById(R.id.btnLogin) }
    private val btnCreateAccount: Button by lazy { findViewById(R.id.btnCreateAccount) }

    private val mAuth:FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnCreateAccount.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            if (etEmail.text.toString().isEmpty() || etPassword.text.toString().isEmpty()){
                Toast.makeText(this, "email or password field is empty", Toast.LENGTH_LONG).show()
            } else{
                mAuth.signInWithEmailAndPassword(etEmail.text.toString(), etPassword.text.toString())
            }
        }


    }
}