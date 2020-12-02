package com.example.desafio_webservice_digital_house.utils.model


data class ThumbnailModel (
    val path: String
    , val extension: String
) {
    fun getThumbnailPath(imageResolution: String? = "detail"): String {
        return "$path/$imageResolution.$extension".replace("http://", "https://")
    }
}