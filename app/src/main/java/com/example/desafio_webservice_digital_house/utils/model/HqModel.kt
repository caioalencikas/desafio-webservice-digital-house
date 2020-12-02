package com.example.desafio_webservice_digital_house.utils.model

import com.google.gson.annotations.SerializedName

data class HqModel (
    val id: Int
    , val title: String
    , val issueNumber: Double
    , val description: String
    , val pageCount: Int
    , val dates: List<DateModel>
    , val prices: List<PriceModel>
    , val thumbnail: ThumbnailModel?
    , val images: List<ImageModel>
    )