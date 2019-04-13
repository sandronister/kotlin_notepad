package br.com.sandroni.notepad.model

import com.google.gson.annotations.SerializedName

data class Note(
    val id: String,

    @SerializedName(value="titulo")
    val title: String,

    @SerializedName(value="descricao")
    val description: String
)