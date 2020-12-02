package com.example.desafio_webservice_digital_house.account

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.desafio_webservice_digital_house.main.view.MainActivity
import com.example.desafio_webservice_digital_house.R
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        
        val btnCreateAccount = findViewById<Button>(R.id.btnCreateAccount)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnCreateAccount.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            checkFields()
        }
    }


    class MyClass{
        companion object{
            var activity: Activity? = null
        }
    }


    private fun checkFields() {

        val email = findViewById<TextInputEditText>(R.id.edtTxtEmailLogin)
        val password = findViewById<TextInputEditText>(R.id.edtTxtPasswordLogin)

        when {
            email.text.toString().trim().isBlank() -> {
                email.error = "O e-mail deve estar preenchido"
            }
            password.text.toString().trim().isBlank() -> {
                password.error = "A senha deve estar preenchida"
            }
            else -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
    }

}