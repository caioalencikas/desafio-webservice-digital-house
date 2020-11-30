package com.example.desafio_webservice_digital_house.utils.repository

import android.content.Context
import com.example.desafio_webservice_digital_house.R
import com.example.desafio_webservice_digital_house.utils.model.HqModel

class HqRepository(private val context: Context) {
    val summary = "The Greatest Super Hero of All Time Returns! The world maay have changed since Spidey's been gone, but so has Peter parker. This is a man with a second chance at life, and ghes not wasting a momonet of it. sam eparker luck, new partker attitutde putting the frinedlu back n the neighbordhoood the hero back into super hero, adn the amazing back into spider-man also returning the recharged and erenergiczed electro"
    val name = "AMAZING SPIDER-MAN (2014) #1 (MHAN VARIANT)"
    val date = "April 30, 2014"

    val hq = HqModel(96, R.drawable.img_splash_screen, name, summary, date, 5.99, 38)
    val hqList = mutableListOf(hq, hq, hq, hq, hq, hq, hq, hq, hq, hq, hq, hq, hq, hq, hq)

    fun getHqList(calback: (hqList: MutableList<HqModel>) -> Unit) {
        calback.invoke(hqList)
    }

}