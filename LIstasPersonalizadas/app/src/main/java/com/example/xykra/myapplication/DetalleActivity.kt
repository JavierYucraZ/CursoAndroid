package com.example.xykra.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle.*

class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        supportActionBar!!.hide()

        val pokemon = intent.getSerializableExtra("poke") as Pokemon

        tvDetalleNombre.text = pokemon.titulo
        tvDetalleHabilidades.text = pokemon.subtitulo
        ivDetalleImagen.setImageResource(pokemon.imagen)

    }
}
