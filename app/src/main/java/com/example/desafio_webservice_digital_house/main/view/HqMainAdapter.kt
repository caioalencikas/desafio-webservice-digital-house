package com.example.desafio_webservice_digital_house.main.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_webservice_digital_house.R
import com.example.desafio_webservice_digital_house.utils.model.HqModel
import com.squareup.picasso.Picasso

class HqMainAdapter (private val dataset: List<HqModel>, private val listener: (HqModel) -> Unit):
    RecyclerView.Adapter<HqMainAdapter.HqMainViewHolder>() {

    class HqMainViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val _thumbnail: ImageView = view.findViewById(R.id.imgHqMain)
        private val _image: ImageView? = view.findViewById(R.id.imgPoster)
        private val hqId = view.findViewById<TextView>(R.id.txtId)

        @SuppressLint("SetTextI18n")
        fun bind(hqDetails: HqModel) {
            hqId.text = " # ${hqDetails.id}"
            val thumbnailPath = hqDetails.thumbnail?.getThumbnailPath()
            Picasso.get().load(thumbnailPath).into(_thumbnail)

            if (_image != null) {
                val imagePath = hqDetails.images[0].getImagePath()
                Picasso.get().load(imagePath).into(_image)
            }
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