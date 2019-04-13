package br.com.sandroni.notepad.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.facebook.stetho.okhttp3.StethoInterceptor



class RetrofitAPI<T> {

    fun getClient(c:Class<T>): T{

        val retrofit = Retrofit.Builder()
            .baseUrl("https://blocodenotasmeunome.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkhttpClient())
            .build()

        return retrofit.create(c)
    }

}

fun getOkhttpClient(): OkHttpClient{
    return OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor())
        .build();
}

fun getNotaAPI():ApiNote{
    return RetrofitAPI<ApiNote>().getClient(ApiNote::class.java)
}
