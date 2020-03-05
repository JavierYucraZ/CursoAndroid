package com.example.xykra.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener {

    val DEVUELVE_DATOS = 2
    val PERMISO_LLAMADA = 123


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ibAbrirMarcado.setOnClickListener( this )
        ibLlamar.setOnClickListener( this )
        ibAbrirGoogleMaps.setOnClickListener ( this )
        ibAbrirStreetView.setOnClickListener ( this )
        ibAbrirPaginaWeb.setOnClickListener ( this )
        ibAbrirBuscador.setOnClickListener ( this )
        ibCompartirTexto.setOnClickListener ( this )
        ibEnviarEmail.setOnClickListener ( this )
        ibAbrirApp.setOnClickListener ( this )
        ibAsignarWallpaper.setOnClickListener ( this )

        ibAbrirActivity.setOnClickListener{
            abrirActiviy()
        }

        ibEnviarDatos.setOnClickListener {
            enviarDatos()
        }

        ibDevolverDatos.setOnClickListener {
            devolverDatos()
        }

    }

    override fun onClick( view : View? ) {
        when(view!!.id){
            /*
            ibAbrirMarcado.id -> abrirMarcado()
            ibLlamar.id -> llamar()
            ibAbrirGoogleMaps.id -> abrirGoogleMaps()
            ibAbrirStreetView.id -> abrirStreetView()
            ibAbrirPaginaWeb.id -> abrirPaginaWeb()
            ibAbrirBuscador.id -> abrirBuscador()
            ibCompartirTexto.id -> compartirTexto()
            ibEnviarEmail.id -> enviarEmail()
            ibAbrirApp.id -> abrirApp()
            ibAsignarWallpaper.id -> asignarWallpaper()

             */
        }
    }


    fun abrirActiviy(){
        val intent = Intent(this, SegundaActivity::class.java)
        startActivity(intent)
    }

    fun enviarDatos(){
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("valor1", "Envio de dato")
        intent.putExtra("valor2", "Hola Mundo")
        startActivity(intent)
    }

    fun devolverDatos(){
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("valor3", "Mi nombre es : ")
        startActivityForResult(intent, DEVUELVE_DATOS)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == DEVUELVE_DATOS){
            if (resultCode == Activity.RESULT_OK){
                val resultado = data!!.getStringExtra("respuesta").toString()
                Toast.makeText(this, "Respuesta : $resultado", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Se cancelo la respuesta", Toast.LENGTH_LONG).show()
            }
        }
    }




}
