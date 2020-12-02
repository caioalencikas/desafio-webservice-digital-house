package com.example.desafio_webservice_digital_house.utils.repository

import android.content.Context
import com.example.desafio_webservice_digital_house.R
import com.example.desafio_webservice_digital_house.utils.model.HqModel
import com.example.desafio_webservice_digital_house.utils.model.ThumbnailModel

class HqRepository{

    private val client = HqEndpoint.Endpoint

    suspend fun getHqs(offset: Int? = 0) = client.getHqs(offset)

}