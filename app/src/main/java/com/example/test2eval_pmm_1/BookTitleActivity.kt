package com.example.test2eval_pmm_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.lang.NumberFormatException

class BookTitleActivity : AppCompatActivity() {
    private lateinit var btnsiguiente : Button
    private lateinit var nombre : EditText
    private lateinit var pag : EditText

    private var comprobado = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_title)

        btnsiguiente = findViewById(R.id.aTitlebuttonSiguiente)
        nombre = findViewById(R.id.editTextNombre)
        pag = findViewById(R.id.editTextPag)

        val array = intent.getStringArrayExtra("arrayLibros")

        btnsiguiente.setOnClickListener{
            comprobar()
            if (comprobado){
                intent = Intent(this@BookTitleActivity, BookDetailsActivity::class.java)
                intent.putExtra("nombreLibro", "${nombre.text}")
                intent.putExtra("numPag", "${pag.text}")
                //intent.putStringArrayListExtra("arrayLibros")
                startActivity(intent)
            }
        }
    }

    private fun comprobar() {
        if (nombre.text.isNotEmpty() && pag.text.isNotEmpty()){
            try {
                if (pag.text.toString().toInt() > 0) comprobado = true
            }catch (e : NumberFormatException){
                Log.i("infoL", "no es un numero")
            }
        }
    }
}