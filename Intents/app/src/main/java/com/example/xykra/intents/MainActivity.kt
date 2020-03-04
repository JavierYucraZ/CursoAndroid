package com.example.xykra.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnIrSegunda.setOnClickListener{
            val intent = Intent(this, SegundaActivity::class.java)
            startActivity(intent)
        }

        btnIrTercera.setOnClickListener{
            val intent = Intent(this, TerceraActivity::class.java)
            startActivity(intent)
        }

    }

}
