package com.example.recyclerviewcard

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() , CustomAdapter.OnItemClickListener{
    lateinit var recycler: RecyclerView
    private var dataname = ArrayList<String>()
    private var dataimage = ArrayList<Int>()
    private lateinit var adapter:CustomAdapter
    lateinit var delete : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        delete = findViewById(R.id.delete)
            delete.setOnClickListener {
                fun onSwiped(viewHolder: RecyclerView.ViewHolder) {
                    val position = viewHolder.adapterPosition
                    dataimage.removeAt(position)

                }
            }

        //1
        //preparedata()
        val gouvernorats = listOf(
            "tunis",
            "manouba",
            "ariana",
            "benarous",
            "nabeul",
            "bizerte",
            "beja",
            "zaghouan",
            "siliana",
            "kef",
            "kairouan",
            "sousse",
            "sfax",
            "monastir",
            "mednine",
            "mahdia",
            "gabes",
            "gafsa",
            "kasserine",
            "sidibouzid",
            "jendouba",
            "kebili",
            "tozeur",
            "tataouine"
        )
        var drawableArray = arrayOf<Int>(
            R.drawable.tunis, R.drawable.manouba, R.drawable.ariana,  R.drawable.benarous,
            R.drawable.nabeul, R.drawable.bizerte, R.drawable.beja, R.drawable.zaghouan,
            R.drawable.siliana, R.drawable.kef, R.drawable.kairouan, R.drawable.sousse,
            R.drawable.sfax, R.drawable.monastir, R.drawable.mednine, R.drawable.mahdia,
            R.drawable.gabes, R.drawable.gafsa, R.drawable.kasserine, R.drawable.sidibouzid,
            R.drawable.jendouba, R.drawable.kebili, R.drawable.tozeur, R.drawable.tataouine,
        )
    for (i in 0..23)
    {
        dataname.add(gouvernorats[i])
        dataimage.add(drawableArray[i])
    }


        //2
        recycler = findViewById(R.id.recyclerView)
        adapter = CustomAdapter(this, dataname, dataimage )

        // affecter au recycler
        val layoutRecycler = LinearLayoutManager(applicationContext)
        recycler.layoutManager = layoutRecycler
        recycler.adapter = adapter

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(applicationContext,"item $position selected", Toast.LENGTH_LONG).show()

    }

    override fun onLongItemClick(position: Int) {
        dataname.removeAt(position)
        dataimage.removeAt(position)
        adapter.notifyItemRemoved(position)

    }

    private fun preparedata(){

        adapter.notifyDataSetChanged()
    }



}