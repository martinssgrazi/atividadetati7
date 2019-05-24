package br.com.edu.ifpr.grazi.myapplication.entidades

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*


class Noticia(
        @SerializedName("author")
        var autor: String,
        @SerializedName("title")
        var titulo: String,
        @SerializedName("description")
        var descricao: String,
        @SerializedName("url")
        var url: String,
        var urlToImage: String,
        @SerializedName("publishedAt")
        var publicado: Date,
        @SerializedName("content")
        var conteudo: String

    )
