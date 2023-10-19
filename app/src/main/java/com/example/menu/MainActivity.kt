package com.example.menu

import Listener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.sax.EndElementListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var x:Menu
    lateinit var listener: Listener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        x = Menu(this, R.raw.menu)
        listener = Listener(this)
        var begin:EditText? = findViewById(R.id.begin)
        var end:EditText? = findViewById(R.id.end)
        var distant:TextView? = findViewById(R.id.distant)
        var button:Button? = findViewById(R.id.button)
        button?.setOnClickListener(listener)
    }
}