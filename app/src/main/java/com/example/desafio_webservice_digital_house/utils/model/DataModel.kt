package com.example.desafio_webservice_digital_house.utils.model

data class DataModel<T>(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<T>
)