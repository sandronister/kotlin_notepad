package br.com.sandroni.notepad.api

import br.com.sandroni.notepad.model.Note
import retrofit2.Call
import retrofit2.http.GET

interface ApiNote{

    @GET("/nota")
    fun getNotes():Call<List<Note>>

}