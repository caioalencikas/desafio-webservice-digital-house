package com.example.desafio_webservice_digital_house.detail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.desafio_webservice_digital_house.R
import com.example.desafio_webservice_digital_house.detail.viewModel.HqDetailsViewModel
import com.example.desafio_webservice_digital_house.utils.repository.HqRepository

class HqDetailsActivity : AppCompatActivity() {

    private lateinit var _viewModel: HqDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hq_details)

        val _intent = intent
        val hqName: String = _intent.getStringExtra("NAME")!!
        val hqDatePublished: String = _intent.getStringExtra("DATE")!!
        val hqSummary: String = _intent.getStringExtra("SUMMARY")!!
        val hqImage: Int = _intent.getIntExtra("IMAGE", 0)!!
        val hqPrice: String = _intent.getDoubleExtra("PRICE", 0.0).toString()!!
        val hqPages: String = _intent.getIntExtra("PAGES",0).toString()!!

        val image = this.findViewById<ImageView>(R.id.imgHqDetails)
        val name = this.findViewById<TextView>(R.id.txtNameHqDetails)
        val summary = this.findViewById<TextView>(R.id.txtSummaryHqDetails)
        val date = this.findViewById<TextView>(R.id.txtDateHqDetails)
        val price = this.findViewById<TextView>(R.id.txtPriceHqDetails)
        val pages = this.findViewById<TextView>(R.id.txtPagesHqDetails)

        name.text = hqName
        summary.text = hqSummary
        date.text = hqDatePublished
        price.text = hqPrice
        pages.text = hqPages

        image.setImageResource(hqImage)

        _viewModel = ViewModelProvider(
            this,
            HqDetailsViewModel.HqDetailsViewModelFactory(HqRepository(this))
        ).get(HqDetailsViewModel::class.java)


        _viewModel.getHqList()

    }
}