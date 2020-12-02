package com.example.desafio_webservice_digital_house.utils.model


data class ImageModel(
    val path: String
    , val extension: String
){
    fun getImagePath(imageResolution: String? = "detail"): String {
        return "$path/$imageResolution.$extension".replace("http://", "https://")
    }
}
