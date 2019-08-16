package com.example.inicumalatihan.viewModel.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.inicumalatihan.models.room.Dikti
import com.example.inicumalatihan.repository.DiktiRepository

class DiktiViewModel : ViewModel(){
    private var mutableLiveData : MutableLiveData<List<Dikti>> ?= null
    private var diktiRepository : DiktiRepository ?= null

    init {
        if (mutableLiveData != null){
            true
        }
        diktiRepository = DiktiRepository().getInstance()
        mutableLiveData = diktiRepository!!.getDataDikti()
    }

    fun getDiktiRepository() : LiveData<List<Dikti>>? {
        return mutableLiveData
    }
}