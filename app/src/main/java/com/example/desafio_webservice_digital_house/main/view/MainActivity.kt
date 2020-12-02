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

    }

    private fun createHqView() {
        _viewModel = ViewModelProvider(
            this,
            HqMainViewModel.HqMainViewModelFactory(HqRepository())
        ).get(HqMainViewModel::class.java)

        _viewModel.getList().observe({ lifecycle }, Observer {
            createHqList(it)
        })

    }

    private fun createHqList(hqList: List<HqModel>) {
        val viewManagerPhotos = GridLayoutManager(this, 3)
        val recyclerViewPhotos = findViewById<RecyclerView>(R.id.recyclerView)

        val viewAdapterPhotos = HqMainAdapter(hqList) {
            val intent = Intent(this@MainActivity, HqDetailsActivity::class.java)
            intent.putExtra("ID", it.id)
            intent.putExtra("TITLE", it.title)
            intent.putExtra("ISSUE_NUMBER", it.issueNumber)
            intent.putExtra("DESCRIPTION", it.description)
            intent.putExtra("PAGE_COUNT", it.pageCount)
            intent.putExtra("DATE", it.dates.lastIndex)
            intent.putExtra("PRICE", it.prices.lastIndex)
            intent.putExtra("THUMBNAIL", it.thumbnail?.getImagePath())
            intent.putExtra("IMAGE", it.images.size)

            startActivity(intent)
        }

        recyclerViewPhotos?.apply {
            layoutManager = viewManagerPhotos
            adapter = viewAdapterPhotos
        }
    }
}