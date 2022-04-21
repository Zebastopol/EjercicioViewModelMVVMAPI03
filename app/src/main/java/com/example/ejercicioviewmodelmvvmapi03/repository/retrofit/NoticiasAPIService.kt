package com.example.ejercicioviewmodelmvvmapi03.repository.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NoticiasAPIService {

    @GET("news?access_key=fecfb06536676af8c841e313707c1dbe&countries=cl")
    fun obtenerNoticias(@Query("languajes") languajes: String): Call<Noticias>

    @GET("news?access_key=fecfb06536676af8c841e313707c1dbe&countries=cl&")
    fun obtenerPalabraClave(@Query("keywords")keywords: String): Call<Noticias>
}
