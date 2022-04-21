package com.example.ejercicioviewmodelmvvmapi03.repository.interactor

import com.example.ejercicioviewmodelmvvmapi03.repository.retrofit.Noticias
import com.example.ejercicioviewmodelmvvmapi03.repository.retrofit.NoticiasAPIService
import com.example.ejercicioviewmodelmvvmapi03.repository.retrofit.RestEngine
import retrofit2.Call

class NoticiasInteractor {

       fun traerLenguaje(languages: String): Noticias?{
            val llamada: NoticiasAPIService =
                RestEngine.getRestEngine().create(NoticiasAPIService::class.java)
            val resultado: Call<Noticias> = llamada.obtenerNoticias(languages)
            val p: Noticias? = resultado.execute().body()

            return p
       }

       fun traerKeyword(keywords: String): Noticias?{
           val llamada: NoticiasAPIService =
               RestEngine.getRestEngine().create(NoticiasAPIService::class.java)
           val resultado: Call<Noticias> = llamada.obtenerPalabraClave(keywords)
           val p: Noticias? = resultado.execute().body()

           return p
       }



}
