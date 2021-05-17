package com.carlos.kotlin_reactmanual

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlos.kotlin_reactmanual.databinding.ItemMainBinding

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    var items = emptyList<String>()
    var count = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("TAG1","create" + count)
        count++
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       Log.d("TAG1","create" + position)

        holder.bindView(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding  = ItemMainBinding.bind(itemView)
        var count = 0

        fun bindView( number: String){
            binding.tvNumber.text = number
        }
    }
}