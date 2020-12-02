package com.example.desafio_webservice_digital_house.utils

class ServicoRetrofit {
    private val PRIVATE_KEY = "ac6feeed7a4220efd12c709428d4afb36bdff2b1"
    private val PUBLIC_KEY = "2381a1811787e1f4fe657d0b159d8bb6"


    fun getHash(): String? {
        return ExtensionMarvelApi.md5(getTimeStamp() + PRIVATE_KEY + PUBLIC_KEY)
    }
}