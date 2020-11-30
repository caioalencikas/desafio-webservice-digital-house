package com.example.desafio_webservice_digital_house.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.desafio_webservice_digital_house.main.MainActivity
import com.example.desafio_webservice_digital_house.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        
        val btnCreateAccount = findViewById<Button>(R.id.btnCreateAccount)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnCreateAccount.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        
        
    }
}