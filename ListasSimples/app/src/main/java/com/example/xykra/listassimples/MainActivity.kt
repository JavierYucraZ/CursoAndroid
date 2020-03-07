package com.example.xykra.listassimples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var datos = ArrayList<String>()

        for (i in 0..100){
            datos.add("Item en posicion : ${i+1}")
        }

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, datos)

        lvDatos!!.adapter = adaptador

        lvDatos!!.setOnItemClickListener{ parent, view, position, id ->
            Toast.makeText(applicationContext, "Click en ${position + 1}", Toast.LENGTH_SHORT).show()
        }
    }
}
