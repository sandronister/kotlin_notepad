package br.com.sandroni.notepad.repository

import br.com.sandroni.notepad.api.getNotaAPI
import br.com.sandroni.notepad.model.Note
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryNote{

    fun searchAll(
        onComplete:(List<Note>?) -> Unit,
        onError:(Throwable?) -> Unit
    ){

        getNotaAPI()
            .getNotes()
            .enqueue(object :Callback<List<Note>>{
                override fun onFailure(call: Call<List<Note>>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<List<Note>>, response: Response<List<Note>>) {

                    if(response.isSuccessful){
                        onComplete(response.body())
                    }else {
                        onError(Throwable("Erro ao buscar os dados"))
                    }
                }
            })
    }
}