package com.example.xykra.floatingactionbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    var fab : FloatingActionButton? = null

    var fab1 : FloatingActionButton? = null
    var fab2 : FloatingActionButton? = null
    var fab3 : FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
