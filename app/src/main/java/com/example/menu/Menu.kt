package com.example.menu

import android.content.Context
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader

class Menu(context: Context, resourceId: Int) {
    var dish: Array<Array<String>> = arrayOf()
    var important: Array<Array<Int>> = arrayOf()

    init {
        val inputStream = context.resources.openRawResource(resourceId)
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        bufferedReader.use { reader ->
            var dishItem = arrayOf<String>()
            var importantItem = arrayOf<Int>()
            reader.forEachLine { line ->
                val split = line.split(";")
                if (split.size == 2) {
                    var x = split[0]
                    var y = split[1].toInt()
                    if (x != "0" || y != 0) {
                        dishItem += x
                        importantItem += y
                    } else {
                        dish += dishItem
                        important += importantItem
                        dishItem = arrayOf()
                        importantItem = arrayOf()
                    }
                }
            }
            if (dishItem.isNotEmpty() && importantItem.isNotEmpty()) {
                dish += dishItem
                important += importantItem
            }
            Log.d("size", dish.size.toString())
        }
    }
}