package com.example.inicumalatihan.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <S> cteateService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }
}