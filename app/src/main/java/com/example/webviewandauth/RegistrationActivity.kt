package com.example.webviewandauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegistrationActivity : AppCompatActivity() {

    private val etEmailReg: EditText by lazy { findViewById(R.id.etEmailReg) }
    private val etPasswordReg: EditText by lazy { findViewById(R.id.etPasswordReg) }
    private val btnRegistration: Button by lazy { findViewById(R.id.btnRegistration) }

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        auth = Firebase.auth

        btnRegistration.setOnClickListener {

            if (etEmailReg.text.toString().isEmpty() || etPasswordReg.text.toString().isEmpty()) {
                toastReg("email or password field is empty")
            } else {
                Log.d("Debug", "click btnRegistration -> else ->")
                auth.createUserWithEmailAndPassword(
                    etEmailReg.text.toString(),
                    etPasswordReg.text.toString()
                ).addOnCompleteListener(this) { task ->
                    Log.d("Debug", "click btnRegistration -> else -> task ->")
                    if (task.isSuccessful) {
                        Log.d("Debug", "click btnRegistration -> else -> task -> success")
                        toastReg("Registration success")
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        toastReg("Registration failed")
                    }
                }
            }

        }

    }


    fun toastReg(text: String) {
        Toast.makeText(this, "$text", Toast.LENGTH_LONG).show()
    }

}