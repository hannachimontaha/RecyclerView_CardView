package com.example.recyclerviewcard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class CustomAdapter(private val listener: OnItemClickListener,
                             private var gouvernorats: List<String>,
                             private var drawableArray: ArrayList<Int> ) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return MyViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val name = gouvernorats[position]
        holder.item1.text = name
        val image = drawableArray[position]
        holder.item2.setImageResource(image)

    }

    override fun getItemCount(): Int {
        return gouvernorats.size
    }

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        var item1: TextView = view.findViewById(R.id.gouvernoratname)
        var item2: ImageView = view.findViewById(R.id.imageView)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

        interface OnItemClickListener {
            fun onItemClick(position: Int)
            fun onLongItemClick(position: Int)

        }

}