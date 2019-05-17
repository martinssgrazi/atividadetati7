package br.com.edu.ifpr.grazi.myapplication.entidades

import com.google.gson.annotations.SerializedName


class Noticia(
        @SerializedName("author")
        var autor: String,
        @SerializedName("title")
        var titulo: String,
        @SerializedName("description")
        var descricao: String,
        var url: String,
        var urlToImage: String,
        @SerializedName("publishedAt")
        var publicado: String,
        @SerializedName("content")
        var conteudo: String
    )
