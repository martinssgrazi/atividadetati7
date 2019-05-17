package br.com.edu.ifpr.grazi.myapplication.entidades

import com.google.gson.annotations.SerializedName

class ResultadoNoticias (
    var status: String,
    @SerializedName("totalResults")
    var resultadoTotal: Int,
    @SerializedName("articles")
    var noticias: List<Noticia>
)