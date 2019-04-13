package br.com.sandroni.notepad.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitAPI<T> {

    fun getClient(c:Class<T>): T{

        val retrofit = Retrofit.Builder()
            .baseUrl("https://blocodenotasmeunome.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(c)
    }

}

fun getNotaAPI():ApiNote{
    return RetrofitAPI<ApiNote>().getClient(ApiNote::class.java)
}
