package com.example.xykra.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , AdapterView.OnItemClickListener {

    var activity : Activity? = null
    var adaptador : CustomAdapter? = null
    var datos : ArrayList<Pokemon>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        activity = this
        datos = ArrayList()

        llenarPokemones()

        adaptador = CustomAdapter(activity!!, datos!!)

        lvLista!!.adapter = adaptador
        lvLista!!.onItemClickListener = this

    }

    fun llenarPokemones(){
        val arrayNombres = resources.getStringArray(R.array.nombre)
        val arrayTipos = resources.getStringArray(R.array.tipos)
        val arrayImagenes = resources.obtainTypedArray(R.array.image)

        for (i in arrayNombres.indices){
            var poke = Pokemon()
            poke.titulo = arrayNombres[i]
            poke.subtitulo = arrayTipos[i]
            poke.imagen = arrayImagenes.getResourceId(i,-1)
            datos!!.add(poke)
        }
    }


    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("poke", datos!![position])
        startActivity(intent)
    }

}
