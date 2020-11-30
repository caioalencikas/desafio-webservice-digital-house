package com.example.desafio_webservice_digital_house.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.desafio_webservice_digital_house.main.view.MainActivity
import com.example.desafio_webservice_digital_house.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}