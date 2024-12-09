package com.goksu.to_doapp.app

import android.app.Application
import android.content.Context

open class App: Application(){

    override fun onCreate(){
        super.onCreate()
    }
}

val Context.app:App
    get()=applicationContext as App