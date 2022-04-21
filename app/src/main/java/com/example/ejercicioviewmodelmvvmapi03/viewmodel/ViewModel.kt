package com.example.ejercicioviewmodelmvvmapi03.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejercicioviewmodelmvvmapi03.repository.interactor.NoticiasInteractor
import com.example.ejercicioviewmodelmvvmapi03.repository.retrofit.Noticias
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {

    val noticias: MutableLiveData<Noticias> = MutableLiveData()
    val interactor = NoticiasInteractor()

    fun onBtnBuscarNoticias(){
        CoroutineScope(Dispatchers.IO).launch {
            noticias.postValue(interactor.traerLenguaje("es"))

        }
    }

    fun onBuscarKeyword(keywords: String) {
        CoroutineScope(Dispatchers.IO).launch {
            noticias.postValue(interactor.traerKeyword("$keywords"))
        }
    }




}