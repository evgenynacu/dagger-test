package com.example.quadro.daggertest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {
    @Inject
    @Named("test")
    lateinit var str1: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
    }
}

