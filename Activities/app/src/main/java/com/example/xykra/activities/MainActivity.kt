package com.example.xykra.activities

import android.Manifest
import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T





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

    fun abrirMarcado(){
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:70190260")
        startActivity(intent)
    }

    fun abrirGoogleMaps(){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("geo:-16.501688,-68.1327745")
        startActivity(intent)
    }

    fun abrirStreetView(){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("google.streetview:cbll=-16.501688,-68.1327745")
        startActivity(intent)
    }

    fun abrirPaginaWeb(){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.google.com")
        startActivity(intent)
    }

    fun abrirBuscador(){
        val intent = Intent(Intent.ACTION_WEB_SEARCH)
        intent.putExtra(SearchManager.QUERY, "Android")
        startActivity(intent)
    }

    fun compartirTexto(){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "Hola a todos")
        startActivity(intent)
    }

    fun enviarEmail(){
        val TO = arrayOf("yucrazj@gmail.com")
        val CC = arrayOf("info@example.com")
        val asunto = "Correo Importante"
        val contenido = "Este es un correo electronico de prueba"

        val intent = Intent(Intent.ACTION_SENDTO)
        intent.type = "text/plain"
        intent.data = Uri.parse("mailto:")

        intent.putExtra(Intent.EXTRA_EMAIL, TO)
        intent.putExtra(Intent.EXTRA_CC, CC)
        intent.putExtra(Intent.EXTRA_SUBJECT, asunto)
        intent.putExtra(Intent.EXTRA_TEXT, contenido)

        startActivity(Intent.createChooser(intent, "Enviar correo (demo)"))

    }

    fun abrirApp(){

        /* Abrir Facebook*/
        val intent = Intent(Intent.ACTION_MAIN)
        intent.setClassName("com.facebook.katana",
            "com.facebook.katana.LoginActivity")
        Toast.makeText(this, "Abriendo Facebook", Toast.LENGTH_SHORT).show()
        startActivity(intent)

        /*Abrir Whatsapp
        val launchIntent = packageManager.getLaunchIntentForPackage("com.whatsapp")
        startActivity(launchIntent)
        */

        /*Abrir Instagram
        val uri = Uri.parse("https://instagram.com/")
        val intent = Intent(Intent.ACTION_VIEW, uri)

        intent.setPackage("com.instagram.android")
        startActivity(intent)
        */

    }

    fun asignarWallpaper(){
        val intent = Intent(Intent.ACTION_SET_WALLPAPER)
        startActivity(Intent.createChooser(intent, "Asignar un wallpaper"))
    }



    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISO_LLAMADA -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                llamar()
            } else {
                Toast.makeText(this, "Permiso denegado", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun llamar(){
        val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
        if (permissionCheck != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), PERMISO_LLAMADA)
        } else {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:70190260")
            startActivity(intent)
        }
    }







}
