package com.example.menu

import Listener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.sax.EndElementListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {
    lateinit var x:Menu
    lateinit var listener: Listener

    fun countDay():String{
        var begin = Calendar.getInstance()
        begin.set(2023, 9, 17)
        var end = Calendar.getInstance()

        var x = (end.timeInMillis - begin.timeInMillis)/(1000.0*3600*24)
        return x.toInt().toString() + " days passed"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        x = Menu(this, R.raw.menu)
        listener = Listener(this)
        var begin:EditText? = findViewById(R.id.begin)
        var end:EditText? = findViewById(R.id.end)

        begin?.setText("17/10/2023")
        var currentDate = SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().time)
        findViewById<TextView>(R.id.distant).text = "${countDay()}"
        end?.setText(currentDate)
        var distant:TextView? = findViewById(R.id.distant)
        var button:Button? = findViewById(R.id.button)
        button?.setOnClickListener(listener)
    }
}