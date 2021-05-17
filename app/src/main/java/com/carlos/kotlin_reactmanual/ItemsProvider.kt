package com.carlos.kotlin_reactmanual

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

object ItemsProvider {

    val observable = Observable<List<String>>(emptyList())
    private var values = emptyList<String>()
    private val random = Random(System.currentTimeMillis())

    fun starEmitting(){
        GlobalScope.launch(Dispatchers.Main) {
            while (true) {
                delay(1000)
                values = values + random.nextInt().toString()
                observable.updateValue(values)
                Log.d("TAG1", values.toString());
            }
        }
    }

}
