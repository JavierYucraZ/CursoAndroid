package com.example.xykra.pedidos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var precio = 2.5
    var total : Double = 0.toDouble()
    var cantidad = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }

    fun mas(v : View){
        cantidad = cantidad + 1
        tvCantidad.text = cantidad.toString()
    }

    fun menos(v : View){
        if (cantidad > 1){
            cantidad = cantidad - 1
        }
        tvCantidad.text = cantidad.toString()
    }

    fun calcular(v : View ){
        total = cantidad * precio
        val nombre = etNombre.text.toString()
        if (!nombre.equals("")){
            tvResumenCantidad.text = cantidad.toString()
            tvResumenPrecioUnitario.text = "Bs. $precio"
            tvResumenCostoTotal.text = "Bs. $total"
            tvResumenNombre.text = nombre
        }else{
            Toast.makeText(this, "Debe proporcionar su nombre", Toast.LENGTH_LONG).show()
        }
    }
}
