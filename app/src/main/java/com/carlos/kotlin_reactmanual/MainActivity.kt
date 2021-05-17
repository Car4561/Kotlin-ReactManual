package com.carlos.kotlin_reactmanual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout.make
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carlos.kotlin_reactmanual.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val adapter = MainAdapter()
    private lateinit var binding : ActivityMainBinding
    private var observer = { items: List<String> -> observer(items)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter

        val observable = Observable(1)
        observable.subscribe { value ->
            //  Toast.makeText(this,value.toString(),Toast.LENGTH_LONG).show()
            Log.d("TAG1", value.toString())
        }
        ItemsProvider.observable.subscribe(observer)
    }

    fun observer(items: List<String>){
        adapter.items = items
        adapter.notifyDataSetChanged()
    }

    override fun onStop() {
        super.onStop()
        ItemsProvider.observable.unsubscribe (observer)
    }

}
