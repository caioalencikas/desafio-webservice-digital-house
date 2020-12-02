package com.example.desafio_webservice_digital_house.utils.repository

import com.example.desafio_webservice_digital_house.utils.network.NetworkUtils
import com.example.desafio_webservice_digital_house.utils.model.HqModel
import com.example.desafio_webservice_digital_house.utils.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface HqEndpoint {
    @GET("/v1/public/creators/1168/comics")
    suspend fun getHqs(@Query("offset") offset: Int? = 0): ResponseModel<HqModel>

    companion object {
        val Endpoint: HqEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(HqEndpoint::class.java)
        }
    }
}