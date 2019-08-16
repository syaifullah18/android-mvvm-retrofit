package com.example.inicumalatihan.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.inicumalatihan.models.remote.Api
import com.example.inicumalatihan.models.room.Dikti
import com.example.inicumalatihan.services.RetrofitService
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


class DiktiRepository {

    private var diktiRepository: DiktiRepository? = null

    fun getInstance(): DiktiRepository {
        if (diktiRepository == null) {
            diktiRepository = DiktiRepository()
        }
        return diktiRepository as DiktiRepository
    }

    private var diktiApi : Api?=null

    constructor(){
        diktiApi = RetrofitService().cteateService(Api::class.java)
    }

    fun getDataDikti() :  MutableLiveData<List<Dikti>> {
        val diktiData = MutableLiveData<List<Dikti>>()
        diktiApi?.getDikti()?.enqueue(object : Callback<List<Dikti>> {
            override fun onFailure(call: Call<List<Dikti>>, t: Throwable) {
                diktiData.setValue(null)
                Log.d("gagal Dikti", t.message)
            }

            override fun onResponse(call: Call<List<Dikti>>, response: Response<List<Dikti>>) {
                if (response.isSuccessful){
                    diktiData.setValue(response.body())
                    Log.d("berhasil", response.message())
                }

            }

        })
        return diktiData
    }

    fun getDataDiktiById() :  MutableLiveData<List<Dikti>> {
        val diktiData = MutableLiveData<List<Dikti>>()
        diktiApi?.getDiktiByID(1)?.enqueue(object : Callback<List<Dikti>> {
            override fun onFailure(call: Call<List<Dikti>>, t: Throwable) {
                diktiData.setValue(null)
                Log.d("gagal Dikti", t.message)
            }

            override fun onResponse(call: Call<List<Dikti>>, response: Response<List<Dikti>>) {
                if (response.isSuccessful){
                    diktiData.setValue(response.body())
                    Log.d("berhasil", response.message())
                }

            }

        })
        return diktiData
    }
}