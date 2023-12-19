package com.example.test2eval_pmm_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class BookDetailsActivity : AppCompatActivity() {
    private lateinit var btnSiguiente : Button
    private lateinit var botonAtras : Button
    private lateinit var nombreAutor : EditText
    private lateinit var fecha : EditText

    private var comprobado = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        btnSiguiente = findViewById(R.id.aDetailsbuttonSiguiente)
        botonAtras = findViewById(R.id.BotonAtras1)
        nombreAutor = findViewById(R.id.editTextNombreA)
        fecha = findViewById(R.id.editTextAnio)
        val nombreLibro = intent.getStringExtra("nombreLibro")
        val numPag = intent.getStringExtra("numPag")

        botonAtras.setOnClickListener {
            intent = Intent(this@BookDetailsActivity, BookTitleActivity::class.java)
            startActivity(intent)
        }
        btnSiguiente.setOnClickListener{
            comprobar()
            if (comprobado){
                intent = Intent(this@BookDetailsActivity, BookDisplayActivity::class.java)
                intent.putExtra("nombreLibro", "${nombreLibro}")
                intent.putExtra("numPag", "${numPag}")
                intent.putExtra("nombreAutor", "${nombreAutor.text}")
                intent.putExtra("fecha", "${fecha.text}")
                startActivity(intent)
            }
        }
    }

    private fun comprobar() {
        if (nombreAutor.text.isNotEmpty() && fecha.text.isNotEmpty()) comprobado = true
        else Log.i("infoL", "faltan datos")
    }
}