package com.example.desafio_webservice_digital_house.main.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_webservice_digital_house.R
import com.example.desafio_webservice_digital_house.utils.model.HqModel
import com.squareup.picasso.Picasso

class HqMainAdapter (private val dataset: List<HqModel>, private val listener: (HqModel) -> Unit):
    RecyclerView.Adapter<HqMainAdapter.HqMainViewHolder>() {

    class HqMainViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val _image: ImageView = view.findViewById(R.id.imgHqMain)

        fun bind(hqDetails: HqModel) {

            val image = hqDetails.image

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
        holder.itemView.setOnClickListener { listener(dataset[position]) }
    }

    override fun getItemCount() = dataset.size
}