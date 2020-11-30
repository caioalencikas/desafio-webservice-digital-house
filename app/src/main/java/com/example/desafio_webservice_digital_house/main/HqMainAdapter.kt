package com.example.desafio_webservice_digital_house.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_webservice_digital_house.R
import com.squareup.picasso.Picasso

class HqMainAdapter (private val dataset: List<Int>): RecyclerView.Adapter<HqMainAdapter.HqMainViewHolder>() {

    class HqMainViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val _image: ImageView = view.findViewById(R.id.imgHqMain)

        fun bind(image: Int) {
            Picasso.get()
                .load(image)
                .into(_image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HqMainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent, false)

        return HqMainViewHolder(view)
    }

    override fun onBindViewHolder(holder: HqMainViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount() = dataset.size
}