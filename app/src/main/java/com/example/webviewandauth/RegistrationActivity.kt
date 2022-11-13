package com.example.webviewandauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {

    private val etEmailReg: EditText by lazy { findViewById(R.id.etEmailReg) }
    private val etPasswordReg: EditText by lazy { findViewById(R.id.etPasswordReg) }
    private val btnRegistration: Button by lazy { findViewById(R.id.btnRegistration) }

    private val mAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btnRegistration.setOnClickListener {

            if (etEmailReg.text.toString().isEmpty() || etPasswordReg.text.toString().isEmpty()) {
                toastReg("email or password field is empty")
            } else {
                mAuth.createUserWithEmailAndPassword(
                    etEmailReg.text.toString(),
                    etPasswordReg.text.toString()
                ).addOnCompleteListener(OnCompleteListener { task ->
                    if (task.isSuccessful) {
                        toastReg("Registration success")
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        toastReg("Registration failed")
                    }
                })
            }

        }

    }

    fun toastReg(text: String) {
        Toast.makeText(this, "$text", Toast.LENGTH_LONG).show()
    }

}