package com.example.desafio_webservice_digital_house.account

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.desafio_webservice_digital_house.main.view.MainActivity
import com.example.desafio_webservice_digital_house.R
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            checkFields()
        }
    }

    private fun checkFields() {

        val name = findViewById<TextInputEditText>(R.id.edtTxtNameRegister)
        val email = findViewById<TextInputEditText>(R.id.edtTxtEmailRegister)
        val password = findViewById<TextInputEditText>(R.id.edtTxtPasswordRegister)

        when {
            email.text.toString().trim().isBlank() -> {
                email.error = "O e-mail deve estar preenchido"
            }
            password.text.toString().trim().isBlank() -> {
                password.error = "A senha deve estar preenchida"
            }
            name.text.toString().trim().isBlank() -> {
                password.error = "A senha deve estar preenchida"
            }
            password.text.toString().trim().length < 6 -> {
                password.error = "A senha digitada deve ter pelo menos 6 caracteres"
            }
            else -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                LoginActivity.MyClass.activity?.finish()
            }
        }
    }

}