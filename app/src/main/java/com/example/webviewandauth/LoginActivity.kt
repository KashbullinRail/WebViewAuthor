package com.example.webviewandauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private val etEmail: EditText by lazy { findViewById(R.id.etEmail) }
    private val etPassword: EditText by lazy { findViewById(R.id.etPassword) }
    private val btnLogin: Button by lazy { findViewById(R.id.btnLogin) }
    private val btnCreateAccount: Button by lazy { findViewById(R.id.btnCreateAccount) }

    private val mAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnCreateAccount.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            if (etEmail.text.toString().isEmpty() || etPassword.text.toString().isEmpty()) {
                toastLogin("email or password field is empty")
            } else {
                mAuth.signInWithEmailAndPassword(
                    etEmail.text.toString(),
                    etPassword.text.toString()
                )
                    .addOnCompleteListener(OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            toastLogin("Authentication success")
                            val intent = Intent(this, WebViewActivity::class.java)
                            startActivity(intent)
                        } else {
                            toastLogin("Authentication failed")
                        }
                    })
            }

        }

    }

    fun toastLogin(text:String){
        Toast.makeText(this,"$text", Toast.LENGTH_LONG).show()
    }

}