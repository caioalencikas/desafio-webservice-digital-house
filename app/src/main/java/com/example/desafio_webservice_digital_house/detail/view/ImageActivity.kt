package com.example.desafio_webservice_digital_house.detail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.desafio_webservice_digital_house.R
import com.squareup.picasso.Picasso

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val thumbnail = intent.getStringExtra("THUMBNAIL")
        Picasso.get()
            .load(thumbnail)
            .into(findViewById<ImageView>(R.id.imgHqImage))

        close()
    }

    private fun close() {
        val imgClose = findViewById<ImageView>(R.id.imgClose)
        imgClose.setOnClickListener {
            onBackPressed()
        }
    }

}