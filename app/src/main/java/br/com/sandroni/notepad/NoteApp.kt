package br.com.sandroni.notepad

import android.app.Application
import com.facebook.stetho.Stetho

class NoteApp:Application(){

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}