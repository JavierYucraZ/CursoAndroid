package com.example.xykra.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_segunda.*


class SegundaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        val bundle = intent.extras

        try{
            tvTextoUno.text = bundle!!.getString("valor1", "")
            tvTextoDos.text = bundle.getString("valor2", "")
        }catch (e: Exception){

        }

        btnRespuesta.setOnClickListener{
            val intent = Intent()
            intent.putExtra("respuesta", etCajaTexto.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }


    }
}
