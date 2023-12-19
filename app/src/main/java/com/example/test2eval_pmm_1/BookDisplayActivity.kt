package com.example.test2eval_pmm_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class BookDisplayActivity : AppCompatActivity() {
    private lateinit var texto : TextView
    private lateinit var nuevolibrobtn : Button
    private lateinit var botonAtras : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_display)
        texto = findViewById(R.id.textoMostrar)
        nuevolibrobtn = findViewById(R.id.nuevolibroButton)
        botonAtras = findViewById(R.id.BotonAtras2)

        val nombreL = intent.getStringExtra("nombreLibro")
        val numP = intent.getStringExtra("numPag")
        val nombreA = intent.getStringExtra("nombreAutor")
        val fecha = intent.getStringExtra("fecha")
        val libro = Libro(nombreL, numP, nombreA, fecha)

        botonAtras.setOnClickListener {
            intent = Intent(this@BookDisplayActivity, BookDetailsActivity::class.java)
            intent.putExtra("nombreLibro", "${nombreL}")
            intent.putExtra("numPag", "${numP}")
            startActivity(intent)
        }
        nuevolibrobtn.setOnClickListener{
            intent = Intent(this@BookDisplayActivity, BookTitleActivity::class.java)
            //intent.putStringArrayListExtra()
            startActivity(intent)
        }

        texto.text = libro.toString()
    }
}