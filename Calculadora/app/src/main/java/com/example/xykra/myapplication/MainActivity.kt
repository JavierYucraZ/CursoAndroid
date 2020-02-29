package com.example.xykra.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var numero1 = Numero1.text
        var numero2 = Numero2.text

        /*
        val -> Constante
        var -> Variable
        */

        Suma.setOnClickListener{
            if (numero1.toString().equals("")  || numero2.toString().equals("")){
                Resultado.text = "Campos vacios"
            }else{
                var suma_resultado = numero1.toString().toDouble() + numero2.toString().toDouble()
                Resultado.text = suma_resultado.toString()
            }
        }

        Resta.setOnClickListener{
            if (numero1.toString().equals("")  || numero2.toString().equals("")){
                Resultado.text = "Campos vacios"
            }else{
                var suma_resultado = numero1.toString().toDouble() - numero2.toString().toDouble()
                Resultado.text = suma_resultado.toString()
            }
        }

        Multiplicacion.setOnClickListener{
            if (numero1.toString().equals("")  || numero2.toString().equals("")){
                Resultado.text = "Campos vacios"
            }else{
                var suma_resultado = numero1.toString().toDouble() * numero2.toString().toDouble()
                Resultado.text = suma_resultado.toString()
            }
        }

        Division.setOnClickListener{
            if (numero1.toString().equals("")  || numero2.toString().equals("")){
                Resultado.text = "Campos vacios"
            }else if(numero2.toString().toInt() == 0){
                Resultado.text = "No existe division entre 0"
            }else{
                var suma_resultado = numero1.toString().toDouble() / numero2.toString().toDouble()
                Resultado.text = suma_resultado.toString()
            }
        }
    }
}
