package com.example.inicumalatihan.models.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.inicumalatihan.models.room.Dikti
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("posts")
    fun getDikti() : Call<List<Dikti>>

    @GET("posts/{id}")
    fun getDiktiByID(@Path("id") id: Int) : Call<List<Dikti>>
}