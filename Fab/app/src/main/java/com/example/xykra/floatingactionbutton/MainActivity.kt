package com.example.xykra.floatingactionbutton

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var fab : FloatingActionButton? = null

    var fab1 : FloatingActionButton? = null
    var fab2 : FloatingActionButton? = null
    var fab3 : FloatingActionButton? = null

    var show_fab_1 : Animation? = null
    var hide_fab_1 : Animation? = null
    var show_fab_2 : Animation? = null
    var hide_fab_2 : Animation? = null
    var show_fab_3 : Animation? = null
    var hide_fab_3 : Animation? = null

    var coord : CoordinatorLayout? = null
    var bandera : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coord = findViewById(R.id.coordinator) as CoordinatorLayout

        fab = findViewById<FloatingActionButton>(R.id.fab)


        fab1 = findViewById<FloatingActionButton>(R.id.fab_1)
        fab2 = findViewById<FloatingActionButton>(R.id.fab_2)
        fab3 = findViewById<FloatingActionButton>(R.id.fab_3)


        show_fab_1 = AnimationUtils.loadAnimation(applicationContext, R.anim.fab1_show)
        hide_fab_1 = AnimationUtils.loadAnimation(applicationContext, R.anim.fab1_hide)
        show_fab_2 = AnimationUtils.loadAnimation(applicationContext, R.anim.fab2_show)
        hide_fab_2 = AnimationUtils.loadAnimation(applicationContext, R.anim.fab2_hide)
        show_fab_3 = AnimationUtils.loadAnimation(applicationContext, R.anim.fab3_show)
        hide_fab_3 = AnimationUtils.loadAnimation(applicationContext, R.anim.fab3_hide)

        fab!!.setOnClickListener {
            if (!bandera){
                expandFAB()
                bandera = true
            }else{
                hideFAB()
                bandera = false
            }
        }

        fab1!!.setOnClickListener {
            val snackbar : Snackbar = Snackbar.make(coord!!, "Mensaje en SnackBar", Snackbar.LENGTH_LONG)
            snackbar.show()
        }

        fab2!!.setOnClickListener {
            val snackbar : Snackbar = Snackbar.make(coord!!, "SnackBar con funcion", Snackbar.LENGTH_LONG)
            snackbar.setAction("Reintentar", View.OnClickListener{
                Toast.makeText(applicationContext, "Accion", Toast.LENGTH_SHORT).show()
            })
            snackbar.show()
        }

        fab3!!.setOnClickListener {
            val snackbar : Snackbar = Snackbar.make(coord!!, "SnackBar Personalizado", Snackbar.LENGTH_LONG)
            snackbar.setAction("Actualizar", View.OnClickListener {
                Toast.makeText(applicationContext, "Accion", Toast.LENGTH_SHORT).show()
            })
            /*Cambiamos color del boton de accion*/
            snackbar.setActionTextColor(Color.RED)
            /**/

            var view : View = snackbar.view

            /*Cambiamos el color del texto en el interior del snackbar*/
            var textView :  TextView = view.findViewById(com.google.android.material.R.id.snackbar_text)
            textView.setTextColor(Color.BLUE)
            /**/

            /*Cambiamos el color de fondo del snackbar*/
            view.setBackgroundColor(Color.YELLOW)
            /**/

            snackbar.show()
        }

    }

    private fun expandFAB() {

        /*Animacion Fab 1*/
        val parametrosDisenio = fab1!!.layoutParams as FrameLayout.LayoutParams
        parametrosDisenio.rightMargin += (fab1!!.width * 1.7).toInt()
        parametrosDisenio.bottomMargin += (fab1!!.height * 0.25).toInt()

        fab1!!.layoutParams = parametrosDisenio
        fab1!!.startAnimation(show_fab_1)
        fab1!!.isClickable = true
        /*Fin animacion 1*/

        /*Animacion 2*/
        val parametrosDisenio2 = fab2!!.layoutParams as FrameLayout.LayoutParams
        parametrosDisenio2.rightMargin += (fab2!!.width * 1.5).toInt()
        parametrosDisenio2.bottomMargin += (fab2!!.height * 1.5).toInt()

        fab2!!.layoutParams = parametrosDisenio2
        fab2!!.startAnimation(show_fab_2)
        fab2!!.isClickable = true
        /*Fin animacion 2*/

        /*Animacion 3*/
        val parametrosDisenio3 = fab3!!.layoutParams as FrameLayout.LayoutParams
        parametrosDisenio3.rightMargin += (fab3!!.width * 0.25).toInt()
        parametrosDisenio3.bottomMargin += (fab3!!.height * 1.7).toInt()

        fab3!!.layoutParams = parametrosDisenio3
        fab3!!.startAnimation(show_fab_3)
        fab3!!.isClickable = true
        /*Fin animacion 3*/
    }

    private fun hideFAB() {
        /*Animacion Fab 1*/
        val parametrosDisenio = fab1!!.layoutParams as FrameLayout.LayoutParams
        parametrosDisenio.rightMargin -= (fab1!!.width * 1.7).toInt()
        parametrosDisenio.bottomMargin -= (fab1!!.height * 0.25).toInt()

        fab1!!.layoutParams = parametrosDisenio
        fab1!!.startAnimation(show_fab_1)
        fab1!!.isClickable = true
        /*Fin animacion 1*/

        /*Animacion 2*/
        val parametrosDisenio2 = fab2!!.layoutParams as FrameLayout.LayoutParams
        parametrosDisenio2.rightMargin -= (fab2!!.width * 1.5).toInt()
        parametrosDisenio2.bottomMargin -= (fab2!!.height * 1.5).toInt()

        fab2!!.layoutParams = parametrosDisenio2
        fab2!!.startAnimation(show_fab_2)
        fab2!!.isClickable = true
        /*Fin animacion 2*/

        /*Animacion 3*/
        val parametrosDisenio3 = fab3!!.layoutParams as FrameLayout.LayoutParams
        parametrosDisenio3.rightMargin -= (fab3!!.width * 0.25).toInt()
        parametrosDisenio3.bottomMargin -= (fab3!!.height * 1.7).toInt()

        fab3!!.layoutParams = parametrosDisenio3
        fab3!!.startAnimation(show_fab_3)
        fab3!!.isClickable = true
        /*Fin animacion 3*/
    }
}
