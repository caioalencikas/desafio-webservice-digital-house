package com.example.desafio_webservice_digital_house.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_webservice_digital_house.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image1 = R.drawable.img_hq1
        val images = listOf(image1, image1, image1, image1, image1, image1, image1, image1, image1, image1, image1)

        val viewManagerPhotos = GridLayoutManager(this, 3)
        val recyclerViewPhotos = findViewById<RecyclerView>(R.id.recyclerView)

        val viewAdapterPhotos = HqMainAdapter(images)

        recyclerViewPhotos?.apply {
            layoutManager = viewManagerPhotos
            adapter = viewAdapterPhotos
        }

    }
}