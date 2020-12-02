package com.example.desafio_webservice_digital_house.detail.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.desafio_webservice_digital_house.R
import com.example.desafio_webservice_digital_house.main.viewModel.HqMainViewModel
import com.example.desafio_webservice_digital_house.utils.repository.HqRepository
import com.squareup.picasso.Picasso

class HqDetailsActivity : AppCompatActivity() {

    private lateinit var _viewModel: HqMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hq_details)

        val imgHqDetails = getData()
        detailsView()
        openImage(imgHqDetails)

        val back = findViewById<ImageView>(R.id.imgBack)

        back.setOnClickListener {
            onBackPressed()
        }


    }

    private fun getData(): String? {
        val id = intent.getStringExtra("ID")
        val title = intent.getStringExtra("TITLE")
        val issueNumber = intent.getStringExtra("ISSUE_NUMBER")
        val description = intent.getStringExtra("DESCRIPTION")
        val pageCount = intent.getStringExtra("PAGE_COUNT")
        val date = intent.getStringExtra("DATE")
        val price = intent.getStringExtra("PRICE")
        val thumbnail = intent.getStringExtra("THUMBNAIL")
        val image = intent.getStringExtra("IMAGE")

        val imageVw = this.findViewById<ImageView>(R.id.imgHqDetails)
        val titleVw = this.findViewById<TextView>(R.id.txtTitleHqDetails)
        val descriptionVw = this.findViewById<TextView>(R.id.txtDescriptionHqDetails)
        val dateVw = this.findViewById<TextView>(R.id.txtDateHqDetails)
        val priceVw = this.findViewById<TextView>(R.id.txtPriceHqDetails)
        val pagesVw = this.findViewById<TextView>(R.id.txtPagesHqDetails)
        val posterVw = this.findViewById<ImageView>(R.id.imgPoster)

        titleVw.text = title
        descriptionVw.text = description
        dateVw.text = date
        priceVw.text = price
        pagesVw.text = pageCount

        Picasso.get()
            .load(thumbnail)
            .into(imageVw)

        Picasso.get()
            .load(image)
            .into(posterVw)


        return thumbnail
    }

    private fun detailsView() {
        _viewModel = ViewModelProvider(
            this,
            HqMainViewModel.HqMainViewModelFactory(HqRepository())
        ).get(HqMainViewModel::class.java)
    }

    private fun openImage(imgHqDetails: String?) {
        val imgHqDetailsVw = findViewById<ImageView>(R.id.imgHqDetails)
        imgHqDetailsVw.setOnClickListener {
            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra("THUMBNAIL", imgHqDetails)
            startActivity(intent)
        }
    }

}