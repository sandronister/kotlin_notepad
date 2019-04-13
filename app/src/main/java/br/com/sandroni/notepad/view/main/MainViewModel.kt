package br.com.sandroni.notepad.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.sandroni.notepad.model.Note
import br.com.sandroni.notepad.repository.RepositoryNote

class MainViewModel: ViewModel() {

    val repositoryNote = RepositoryNote()

    val notes: MutableLiveData<List<Note>>  = MutableLiveData()
    val messageError: MutableLiveData<String> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun searchAll(){
        isLoading.value = true

        repositoryNote.searchAll(
            onComplete = {
                isLoading.value = false
                notes.value = it
            },
            onError = {
                isLoading.value = false
                messageError.value = it?.message
            }
        )
    }
}