package br.com.edu.ifpr.grazi.myapplication.servicos

import br.com.edu.ifpr.grazi.myapplication.entidades.Noticia
import br.com.edu.ifpr.grazi.myapplication.entidades.ResultadoNoticias
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NoticiasService {
    @GET("top-headlines")

    fun getNews(

        @Query("q")
        busca:String,

        @Query("country")
        pais: String = "br",

        @Query("apiKey")
        apiKey: String = "bbe48466499045bea63b3a6bd8914492"

    ): Call<ResultadoNoticias>
}