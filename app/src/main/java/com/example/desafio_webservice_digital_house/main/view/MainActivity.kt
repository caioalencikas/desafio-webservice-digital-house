package com.example.desafio_webservice_digital_house.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_webservice_digital_house.R
import com.example.desafio_webservice_digital_house.detail.view.HqDetailsActivity
import com.example.desafio_webservice_digital_house.main.viewModel.HqMainViewModel
import com.example.desafio_webservice_digital_house.utils.model.HqModel
import com.example.desafio_webservice_digital_house.utils.repository.HqRepository

class MainActivity : AppCompatActivity() {


    private lateinit var _viewModel: HqMainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createHqView()

        val hq = findViewById<CardView>(R.id.crdHqImage)



    }

    private fun createHqView() {
        _viewModel = ViewModelProvider(
            this,
            HqMainViewModel.HqMainViewModelFactory(HqRepository(this))
        ).get(HqMainViewModel::class.java)

        _viewModel.hqList.observe(this, Observer {
            createHqList(it)
        })

        _viewModel.getHqList()
    }

    private fun createHqList(hqList: MutableList<HqModel>) {
        val viewManagerPhotos = GridLayoutManager(this, 3)
        val recyclerViewPhotos = findViewById<RecyclerView>(R.id.recyclerView)

        val viewAdapterPhotos = HqMainAdapter(hqList) {
            val intent = Intent(this, HqDetailsActivity::class.java)
            intent.putExtra("NAME", it.name)
            intent.putExtra("DATE", it.datePublished)
            intent.putExtra("SUMMARY", it.summary)
            intent.putExtra("IMAGE", it.image)
            intent.putExtra("PRICE", it.price)
            intent.putExtra("PAGES", it.pages)

            startActivity(intent)
        }

        recyclerViewPhotos?.apply {
            layoutManager = viewManagerPhotos
            adapter = viewAdapterPhotos
        }
    }
}